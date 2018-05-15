package tdd.practice;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class SmartParkingBoyTest {


    @Test
    public void should_parking_car_when_this_parking_lot_has_most_available_parking_rooms() throws Exception {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);
        Vehicle vehicle1 = new Vehicle();

        //when
        String ticket1 = smartParkingBoy.parking(vehicle1);


        //then
        assertEquals(1, parkingLot1.getAvailableNums());
        assertEquals(1, parkingLot2.getAvailableNums());

    }
}
