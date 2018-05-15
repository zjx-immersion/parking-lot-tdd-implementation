package tdd.practice;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class ParkingBoyTest {

    @Test
    public void should_call_parking_of_parkonglot_when_parking_a_vehicle() throws Exception {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1, parkingLot2);
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        //when
        String ticket1 = parkingBoy.parking(vehicle1);
        String ticket2 = parkingBoy.parking(vehicle2);
        //then
        assertEquals(3, ticket1.length());
        assertEquals(3, ticket2.length());
    }

    @Test
    public void should_get_parking_car_when_it_parking_in_any_parking_lot_boy_manage() throws Exception {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1, parkingLot2);
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        String ticket1 = parkingBoy.parking(vehicle1);
        String ticket2 = parkingBoy.parking(vehicle2);
        //when
        Vehicle pickedVehicle1 = parkingBoy.pickUp(ticket2);
        Vehicle pickedVehicle2 = parkingBoy.pickUp(ticket2);

        //then
        assertEquals(vehicle1, pickedVehicle1);
        assertEquals(vehicle2, pickedVehicle2);
    }


}
