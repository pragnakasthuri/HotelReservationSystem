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
    public void givenHotel_ShouldReturnTrue() {
        boolean result = hotelReservationApplication.addHotel(new Hotel("TestHotel", 2, 100, 120));
        Assertions.assertEquals(true, result);
    }

}
