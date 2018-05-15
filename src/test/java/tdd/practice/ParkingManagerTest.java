package tdd.practice;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class ParkingManagerTest {

    @Test
    public void should_parking_the_vehicles_when_manager_manage_a_parking_lot_and_a_parking_boy() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(1));
        ParkingManager parkingManager = new ParkingManager(parkingBoy, parkingLot, smartParkingBoy);
        Vehicle vehicle = new Vehicle();

        //when
        String ticket1 = parkingManager.parking(vehicle);
        String ticket2 = parkingManager.parking(vehicle);
        String ticket3 = parkingManager.parking(vehicle);

        //then
        assertEquals(3, ticket1.length());
        assertEquals(3, ticket2.length());
        assertEquals(3, ticket3.length());
    }
}
