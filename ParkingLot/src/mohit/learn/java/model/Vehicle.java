package mohit.learn.java.model;

import mohit.learn.java.enums.VehicleType;

import java.time.LocalTime;
import java.util.Date;

public class Vehicle {

    private String vehicleNumber;
    private VehicleType vehicleType;
    private LocalTime entryTime;

    public Vehicle(String vehicleNumber, VehicleType vehicleType, LocalTime entryTime) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.entryTime = entryTime;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }



}
