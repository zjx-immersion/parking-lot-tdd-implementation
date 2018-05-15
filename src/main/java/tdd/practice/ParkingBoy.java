package tdd.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class ParkingBoy {

    private final List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot... initParkingLots) {
        this.parkingLots = Arrays.asList(initParkingLots);
    }


    public String parking(Vehicle vehicle1) {
        Optional<ParkingLot> curParkingLot = this.parkingLots
                .stream()
                .filter(parkingLot -> parkingLot.getAvailableNums() > 0)
                .findFirst();
        String ticket = curParkingLot.get().parking(vehicle1);

        return ticket;
    }

    public Vehicle pickUp(String ticket) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.hasVehicle(ticket))
                .findFirst().get().pickUp(ticket);
    }
}
