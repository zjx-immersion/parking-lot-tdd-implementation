package tdd.practice;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class ParkingManager {
    private final List<Parkable> parkableList;

    public ParkingManager(Parkable ...parkables) {
        this.parkableList = Arrays.asList(parkables) ;
    }

    public String parking(Vehicle vehicle) {
        return parkableList.stream()
                .filter(parkable -> parkable.getAvailableNums() > 0)
                .findFirst().get().parking(vehicle);
    }
}
