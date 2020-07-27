package mohit.learn.java.model;

import mohit.learn.java.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Space {
    private int id;
    private int maxCapacity;
    private boolean isFull;
    private int level;
    private VehicleType vehicleType;
    private List<Location> locationList;

    public Space(int id, int maxCapacity, int level, VehicleType vehicleType) {
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.level = level;
        this.vehicleType = vehicleType;
        this.isFull = false;
        this.createLocation(maxCapacity);
    }

    private void createLocation(int maxCapacity) {
        locationList = new ArrayList<>();
        for(int i=0;i<maxCapacity;i++) {
            locationList.add(new Location(i));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Location> getLocationList() {
        return this.locationList;
    }
}
