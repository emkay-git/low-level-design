package mohit.learn.java.service;

import mohit.learn.java.enums.VehicleType;
import mohit.learn.java.model.Vehicle;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class VehicleService {

    private Map<String,Vehicle> vehicleMap;

    public VehicleService() {
        vehicleMap = new HashMap<>();
    }

    public Vehicle createVehicle(String number, VehicleType vehicleType) {

        Vehicle newVehicle =  new Vehicle(number,vehicleType, LocalTime.now());
        vehicleMap.put(number,newVehicle);
        return newVehicle;
    }


    public Vehicle getVehicleFromList(String number) {
        if(vehicleMap.get(number)==null)  throw new IllegalArgumentException();
        return vehicleMap.get(number);
    }

    public Vehicle removeVehicleFromList(String number) {
        if(vehicleMap.get(number)==null)  throw new IllegalArgumentException();
        return vehicleMap.remove(number);
    }

}
