import com.bridgelabz.Hotel;
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
        List<Map.Entry<String, Double>> result = hotelReservationApplication.printCheapestHotel("11Sep2020,12Sep2020");
        Assertions.assertEquals(result.size(), 2);
        Assertions.assertEquals(result.get(0).getKey(), "Bridgewood");
        Assertions.assertEquals(result.get(1).getKey(), "Lakewood");
    }

    @Test
    public void givenHotelAndRating_whendValidHotelName_ShouldReturnTrue() {
        hotelReservationApplication.hotelList.add(new Hotel("Lakewood", 3, 110.00, 90.00));
        hotelReservationApplication.hotelList.add(new Hotel("Bridgewood", 4, 150.00, 50.00));
        boolean isUpdated = hotelReservationApplication.addRating("Lakewood", 4);
        Assertions.assertEquals(isUpdated, true);
    }

    @Test
    public void givenHotelAndRating_whendInValidHotelName_ShouldReturnFalse() {
        hotelReservationApplication.hotelList.add(new Hotel("Lakewood", 3, 110.00, 90.00));
        hotelReservationApplication.hotelList.add(new Hotel("Bridgewood", 4, 150.00, 50.00));
        boolean isUpdated = hotelReservationApplication.addRating("UnKnownHotel", 4);
        Assertions.assertEquals(isUpdated, false);
    }
}