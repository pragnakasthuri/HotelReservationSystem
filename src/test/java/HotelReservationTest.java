import com.bridgelabz.HotelReservationApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationTest {

    @Test
    public void whenHotelCreation_ShouldReturn3() {
        HotelReservationApplication.createHotels();
        int result = HotelReservationApplication.hotelList.size();
        Assertions.assertEquals(3, result);
    }

}
