package tdd.practice;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by jxzhong on 2018/5/16.
 */
public class ParkingDirectorTest {

    @Test
    public void should_get_the_empty_parking_report_when_call_generate_parking_report_with_no_parking_vehicle() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(2));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(new ParkingLot(2));
        ParkingManager parkingManager = new ParkingManager(parkingLot, parkingBoy, superParkingBoy);
        ParkingDirector parkingDirector = new ParkingDirector(parkingManager);

        //when
        ParkingReport report = parkingDirector.generateReport();

        //then
        assertNotNull(report);
        assertEquals(0, report.getParkingVehicleNum());
    }

    @Test
    public void should_get_the_report_when_every_parking_boy_and_manager_have_parking_vehicles() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(2));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(new ParkingLot(2), new ParkingLot(2));
        ParkingManager parkingManager = new ParkingManager(parkingLot, parkingBoy, superParkingBoy);
        ParkingDirector parkingDirector = new ParkingDirector(parkingManager);
        parkingLot.parking(new Vehicle());
        parkingBoy.parking(new Vehicle());
        superParkingBoy.parking(new Vehicle());
        superParkingBoy.parking(new Vehicle());

        //when
        ParkingReport report = parkingDirector.generateReport();

        //then
        assertEquals(4, report.getParkingVehicleNum());
        assertEquals("M", report.getRoleName());

    }
}
