package tdd.practice;

import org.junit.Test;

import java.util.stream.IntStream;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class SuperParkingBoyTest {

    @Test
    public void should_parking_car_when_this_parking_lot_has_most_available_rate_of_parking_rooms() throws Exception {
        //given
        ParkingLot parkingLot1 = new ParkingLot(6);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot1, parkingLot2);
        Vehicle vehicle1 = new Vehicle();

        //when

        IntStream.rangeClosed(1, 3).forEach(x -> superParkingBoy.parking(vehicle1));


        //then
        assertEquals(4, parkingLot1.getAvailableNums());
        assertEquals(1, parkingLot2.getAvailableNums());

    }
}
