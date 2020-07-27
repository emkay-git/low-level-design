package mohit.learn.java.ui;

import mohit.learn.java.enums.VehicleType;
import mohit.learn.java.service.ParkingService;
import mohit.learn.java.service.VehicleService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkingLotUI {

    private BufferedReader br;
    ParkingService parkingService;
    VehicleService vehicleService;
    public ParkingLotUI(ParkingService parkingService, VehicleService vehicleService) {
        this.parkingService = parkingService;
        this.vehicleService = vehicleService;
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void takeInput() {
        String input;
        while(true) {
            try {
                input = br.readLine();
                String temp[] = input.split(" ");
                if(input.equals("END")) return;
                String eventType = temp[0];
                String number = temp[1];

                VehicleType vehicleType = VehicleType.valueOf(temp[2]);

                switch (eventType) {
                    case "IN" -> this.parkingService.addVehicle(vehicleService.createVehicle(number,vehicleType));
                    case "OUT" -> this.parkingService.removeVehicle(vehicleService.getVehicleFromList(number));
                    default -> throw new IllegalArgumentException("Input format wrong");
                }
            } catch (Exception exception) {
//                exception.printStackTrace();
                System.out.println("Vehicle Rejected");
            }

        }
    }

}
