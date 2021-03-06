package tdd.practice;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class ParkingLotTest {

    @Test
    public void should_get_1_available_parking_room_when_parking_lot_is_empty_and_1_total_place() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        //when
        int availableNum = parkingLot.getAvailableNums();

        //then
        assertEquals(1, availableNum);
    }

    @Test
    public void should_parking_vehicle_success_when_call_packing() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Vehicle vehicle = new Vehicle();
        //when
        String ticket1 = parkingLot.parking(vehicle);
        String ticket2 = parkingLot.parking(vehicle);

        //then

        assertEquals(3, ticket1.length());
        assertEquals(3, ticket2.length());
        assertNotSame(ticket2, ticket1);
        assertEquals(0, parkingLot.getAvailableNums());
    }

    @Test
    public void should_get_indicated_vehicle_when_get_vehicle_via_park_ticket_and_not_only_one_car_in_lot() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        String ticket1 = parkingLot.parking(vehicle1);
        String ticket2 = parkingLot.parking(vehicle2);
        //when
        Vehicle pickedVehicle = parkingLot.pickUp(ticket1);

        //then
        assertEquals(vehicle1, pickedVehicle);
        assertEquals(1, parkingLot.getAvailableNums());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_throw_outofrange_exception_when_parking_vehicle_more_than_total_room_num() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Vehicle vehicle = new Vehicle();
        //when
        parkingLot.parking(vehicle);
        parkingLot.parking(vehicle);
        parkingLot.parking(vehicle);

        //then
    }

    //测测是可以删除
    @Test
    public void should_get_2_available_parking_room_when_parking_lot_has_3_rooms_with_two_vehicle_parked() throws Exception {

        //given
        ParkingLot parkingLot = new ParkingLot(3);
        Vehicle vehicle = new Vehicle();
        String ticket1 = parkingLot.parking(vehicle);

        //when
        int availableNum = parkingLot.getAvailableNums();

        //then
        assertEquals(2, availableNum);
    }

}
