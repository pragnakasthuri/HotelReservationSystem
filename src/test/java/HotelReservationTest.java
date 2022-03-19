import com.bridgelabz.Hotel;
import com.bridgelabz.HotelReservationApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}