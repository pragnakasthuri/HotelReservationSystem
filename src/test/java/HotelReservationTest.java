import com.bridgelabz.Hotel;
import com.bridgelabz.HotelRegistrationValidationUtil;
import com.bridgelabz.HotelReservationApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class HotelReservationTest {

    HotelReservationApplication hotelReservationApplication = null;

    @BeforeEach
    public void init() {
        hotelReservationApplication = new HotelReservationApplication();
    }

    @Test
    public void givenHotelDetails_ShouldReturnTrue() {
        boolean result = hotelReservationApplication.addHotel(new Hotel("TestHotel", 2, 160, 120));
        Assertions.assertEquals(true, result);
    }

    @Test
    public void givenDate_whenWeekDay_ShouldReturnFalse() {
        boolean result = hotelReservationApplication.isWeekend("18mar2022");
        Assertions.assertEquals(result, false);
    }

    @Test
    public void givenDate_whenWeekDay_ShouldReturnTrue() {
        boolean result = hotelReservationApplication.isWeekend("19mar2022");
        Assertions.assertEquals(result, true);
    }

    @Test
    public void givenDates_whenWeekDayAndWeekEnd_ShouldReturnLakeWoodAndBridgewood() {
        hotelReservationApplication.hotelList.add(new Hotel("Lakewood", 3, 110.00, 90.00));
        hotelReservationApplication.hotelList.add(new Hotel("Bridgewood", 4, 150.00, 50.00));
        List<Map.Entry<String, Double>> result = hotelReservationApplication.printCheapestHotel("11Sep2020,12Sep2020", false);
        Assertions.assertEquals(result.size(), 2);
        Assertions.assertEquals(result.get(0).getKey(), "Bridgewood");
        Assertions.assertEquals(result.get(1).getKey(), "Lakewood");
    }

    @Test
    public void givenHotelAndRating_whenValidHotelName_ShouldReturnTrue() {
        hotelReservationApplication.hotelList.add(new Hotel("Lakewood", 3, 110.00, 90.00));
        hotelReservationApplication.hotelList.add(new Hotel("Bridgewood", 4, 150.00, 50.00));
        boolean isUpdated = hotelReservationApplication.addRating("Lakewood", 4);
        Assertions.assertEquals(isUpdated, true);
    }

    @Test
    public void givenHotelAndRating_whenInValidHotelName_ShouldReturnFalse() {
        hotelReservationApplication.hotelList.add(new Hotel("Lakewood", 3, 110.00, 90.00));
        hotelReservationApplication.hotelList.add(new Hotel("Bridgewood", 4, 150.00, 50.00));
        boolean isUpdated = hotelReservationApplication.addRating("UnKnownHotel", 4);
        Assertions.assertEquals(isUpdated, false);
    }

    @Test
    public void givenDates_whenWeekDayAndWeekEnd_ShouldReturnBestRatedAsBridgewood() {
        hotelReservationApplication.hotelList.add(new Hotel("Lakewood", 3, 110.00, 90.00));
        hotelReservationApplication.hotelList.add(new Hotel("Bridgewood", 4, 150.00, 50.00));
        Hotel cheapestBestRatedHotel = hotelReservationApplication.findCheapestBestRatedHotel("11Sep2020,12Sep2020", true);
        Assertions.assertEquals(cheapestBestRatedHotel.getHotelName(), "Bridgewood");
    }

    @Test
    public void whenFindingBestRatedHotel_ShouldReturnRidgewood() {
        hotelReservationApplication.hotelList.add(new Hotel("Lakewood", 3, 110.00, 90.00));
        hotelReservationApplication.hotelList.add(new Hotel("Bridgewood", 4, 150.00, 50.00));
        hotelReservationApplication.hotelList.add(new Hotel("Ridgewood", 5, 220.00, 150.00));
        Hotel bestRatedHotel = hotelReservationApplication.findBestRatedHotel();
        Assertions.assertEquals(bestRatedHotel.getHotelName(), "Ridgewood");
    }

    @Test
    public void givenHotel_whenHotelIsLakewood_ShouldReturnTrue() {
        hotelReservationApplication.hotelList.add(new Hotel("Lakewood", 3, 110.00, 90.00));
        hotelReservationApplication.hotelList.add(new Hotel("Bridgewood", 4, 150.00, 50.00));
        hotelReservationApplication.hotelList.add(new Hotel("Ridgewood", 5, 220.00, 150.00));
        boolean isSuccess = hotelReservationApplication.addRewardRates("Lakewood", 80.00, 80.00);
        Assertions.assertEquals(isSuccess, true);
    }

    @Test
    public void givenHotel_whenHotelIsUnknown_ShouldReturnFalse() {
        hotelReservationApplication.hotelList.add(new Hotel("Lakewood", 3, 110.00, 90.00));
        hotelReservationApplication.hotelList.add(new Hotel("Bridgewood", 4, 150.00, 50.00));
        hotelReservationApplication.hotelList.add(new Hotel("Ridgewood", 5, 220.00, 150.00));
        boolean isSuccess = hotelReservationApplication.addRewardRates("ABC", 80.00, 80.00);
        Assertions.assertEquals(isSuccess, false);
    }

    @Test
    public void givenDates_whenRewardedCustomerAndWeekDayAndWeekEnd_ShouldReturnRidgewood() {
        hotelReservationApplication.hotelList.add(new Hotel("Lakewood", 3, 110.00, 90.00));
        hotelReservationApplication.hotelList.add(new Hotel("Bridgewood", 4, 150.00, 50.00));
        hotelReservationApplication.hotelList.add(new Hotel("Ridgewood", 5, 220.00, 150.00));
        hotelReservationApplication.addRewardRates("Lakewood", 80.00, 80.00);
        hotelReservationApplication.addRewardRates("Bridgewood", 110.00, 50.00);
        hotelReservationApplication.addRewardRates("Ridgewood", 100.00, 40.00);
        Hotel cheapestBestRatedHotel = hotelReservationApplication.findCheapestBestRatedHotel("11Sep2020,12Sep2020", false);
        Assertions.assertEquals(cheapestBestRatedHotel.getHotelName(), "Ridgewood");
    }
    @Test
    public void givenHotelName_WhenProper_ShouldReturnTrue() {
        boolean result = HotelRegistrationValidationUtil.isValidHotelName("Lakewood");
        Assertions.assertEquals(true, result);
    }

    @Test
    public void givenHotelName_WhenNotProper_ShouldReturnFalse() {
        boolean result = HotelRegistrationValidationUtil.isValidHotelName("lakewood");
        Assertions.assertEquals(false, result);
    }

    @Test
    public void givenHotelRating_WhenProper_ShouldReturnTrue() {
        boolean result = HotelRegistrationValidationUtil.isValidHotelRating(5);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void givenHotelRating_WhenNotProper_ShouldReturnFalse() {
        boolean result = HotelRegistrationValidationUtil.isValidHotelRating(578);
        Assertions.assertEquals(false, result);
    }

    @Test
    public void givenHotelWeekDayRate_WhenProper_ShouldReturnTrue() {
        boolean result = HotelRegistrationValidationUtil.isValidWeekDayRate(110.0);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void givenHotelWeekDayRate_WhenNotProper_ShouldReturnFalse() {
        boolean result = HotelRegistrationValidationUtil.isValidWeekDayRate(000.0);
        Assertions.assertEquals(false, result);
    }

    @Test
    public void givenHotelWeekEndRate_WhenProper_ShouldReturnTrue() {
        boolean result = HotelRegistrationValidationUtil.isValidWeekEndRate(1800.0);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void givenHotelWeekEndRate_WhenNotProper_ShouldReturnFalse() {
        boolean result = HotelRegistrationValidationUtil.isValidWeekEndRate(000.0);
        Assertions.assertEquals(false, result);
    }
}