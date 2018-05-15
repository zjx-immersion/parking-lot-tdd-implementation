package tdd.practice;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class ParkingManagerTest {

    @Test
    public void should_parking_the_vehicles_when_manager_manage_a_parking_lot_and_2_parking_boy() throws Exception {
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

    @Test
    public void should_pick_up_the_indicated_vehicles_in_a_parking_of_parking_boy_when_manager_manage_a_parking_lot_and_2_parking_boy() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(1));
        ParkingManager parkingManager = new ParkingManager(parkingBoy, parkingLot, smartParkingBoy);
        Vehicle vehicle = new Vehicle();
        parkingManager.parking(new Vehicle());
        String ticket2 = parkingManager.parking(vehicle);
        parkingManager.parking(new Vehicle());

        //when
        Vehicle pickedVehicle = parkingManager.pickUp(ticket2);

        //then
        assertEquals(vehicle, pickedVehicle);
    }
}
