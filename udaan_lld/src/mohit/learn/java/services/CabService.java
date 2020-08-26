package mohit.learn.java.services;

import mohit.learn.java.enums.JourneyStatus;
import mohit.learn.java.models.Driver;
import mohit.learn.java.models.Journey;
import mohit.learn.java.models.Location;

import java.util.ArrayList;
import java.util.List;

public class DriverService {

    List<Driver> driverList;
    public DriverService() {
        driverList = new ArrayList<>();
    }

    public boolean registerDriver(Driver driver) {
        return driverList.add(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverList;
    }

    public boolean updateLocation(Driver driver, Location location) {
        for(Driver driverItem: driverList) {
            if(driverItem.getLicense().equals(driver.getLicense())) {
                driverItem.setLocation(location);
                return true;
            }
        }

        throw new IllegalCallerException("NO such driver exists");
    }

    public Journey startJourney(Journey journey,Driver driver, Location startLocation) {
        journey.setDriverAssigned(driver);
        journey.setStartLocation(startLocation);
        journey.setStatus(JourneyStatus.STARTED);
        return journey;
    }

    public Journey endTrip(Journey journey, Location endLocation) {
        journey.setStatus(JourneyStatus.COMPLETED);
        journey.setEndLocation(endLocation);
        return journey;
    }

}
