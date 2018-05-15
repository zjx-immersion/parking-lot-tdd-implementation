package tdd.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class ParkingLot {
    private final int totalPlaceNum;
    private int baseTicket;
    private Map<String, Vehicle> parkingRooms;

    public ParkingLot(int totalParkingRoomNum) {
        this.totalPlaceNum = totalParkingRoomNum;
        this.parkingRooms = new HashMap<String, Vehicle>();
        this.baseTicket = 100;
    }

    public int getAvailableNums() {
        return this.totalPlaceNum - parkingRooms.size();
    }

    public String parking(Vehicle vehicle) {

        if(this.parkingRooms.size() >= this.totalPlaceNum){
            throw new IndexOutOfBoundsException("Parking Rooms are full!");
        }
        String newTicket = String.valueOf(this.baseTicket++);
        this.parkingRooms.put(newTicket, vehicle);
        return newTicket;
    }

    public Vehicle pickUp(String ticket) {
        Vehicle vehicle = this.parkingRooms.get(ticket);
        parkingRooms.remove(ticket);
        return vehicle;
    }

    public boolean hasVehicle(String ticket) {
        return parkingRooms.containsKey(ticket);
    }

    public double getAvailableRate() {
        return this.getAvailableNums() / this.totalPlaceNum;
    }
}
