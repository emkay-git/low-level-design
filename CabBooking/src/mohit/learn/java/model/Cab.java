package mohit.learn.java.model;

import mohit.learn.java.enums.CabStatus;

public class Cab {
    private CabStatus cabStatus;
    private Location cabLocation;
    private String carNumber;
    private Driver driver;

    public Cab(Location cabLocation, String carNumber, Driver driver) {
        this.cabLocation = cabLocation;
        this.carNumber = carNumber;
        this.driver = driver;
        this.cabStatus = CabStatus.ONLINE;
    }

    public CabStatus getCabStatus() {
        return cabStatus;
    }

    public void setCabStatus(CabStatus cabStatus) {
        this.cabStatus = cabStatus;
    }

    public Location getCabLocation() {
        return cabLocation;
    }

    public void setCabLocation(Location cabLocation) {
        this.cabLocation = cabLocation;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
