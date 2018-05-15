import org.junit.Test;
import tdd.practice.Parkinglot;
import tdd.practice.Vehicle;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class ParkingLotTest {

    @Test
    public void should_get_1_available_place_when_parking_lot_is_empty_and_1_total_place() throws Exception {
        //given
        Parkinglot parkinglot = new Parkinglot(1);
        //when
        int availableNum = parkinglot.getAvailableNums();

        //then
        assertEquals(1, availableNum);
    }

    @Test
    public void should_parking_vehicle_success_when_call_packing() throws Exception {
        //given
        Parkinglot parkinglot = new Parkinglot(1);
        Vehicle vehicle = new Vehicle();
        //when
        String ticket = parkinglot.parking(vehicle);

        //then

        assertEquals(3, ticket.length());
    }

    @Test
    public void should_get_indicated_vehicle_when_get_vehicle_via_park_ticket() throws Exception {

    }
}
