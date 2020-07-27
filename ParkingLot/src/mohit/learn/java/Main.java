package mohit.learn.java;


import mohit.learn.java.enums.VehicleType;
import mohit.learn.java.model.Space;
import mohit.learn.java.service.ParkingService;
import mohit.learn.java.service.VehicleService;
import mohit.learn.java.ui.ParkingLotUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * You have a parking space for different type of vehicles
 *  1. Car/Van/Auto
 *  2. Trucks/Heavy Vehicles
 *  3. Bikes/2 wheeler
 * User enter from an entry gate, collect the ticket and location to park
 * User leaves the exit gate and pay the amount based on time per 1hr  -
 *      50rs 100rs 200rs for three types of vehicles
 * On full capacity reject the vehicles.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Space spaceLarge = new Space(1,3,1, VehicleType.LARGE_VEHICLE);
        Space spaceMedium = new Space(2,3,1,VehicleType.MEDIUM_VEHICLE);
        Space spaceSmall = new Space(3,2,2,VehicleType.SMALL_VEHICLE);
        List<Space> spaceList = new ArrayList<>();
        spaceList.add(spaceMedium);
        spaceList.add(spaceLarge);
        spaceList.add(spaceSmall);
        VehicleService vehicleService = new VehicleService();
        ParkingService parkingService = new ParkingService(spaceList,vehicleService);
        ParkingLotUI parkingLotUI = new ParkingLotUI(parkingService,vehicleService);
        parkingLotUI.takeInput();
    }
}
