package mohit.learn.java.service;

import mohit.learn.java.enums.Avialability;
import mohit.learn.java.enums.VehicleType;
import mohit.learn.java.model.Location;
import mohit.learn.java.model.Space;
import mohit.learn.java.model.Vehicle;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingService {

    List<Space> parkingSpaceList;
    Map<Vehicle,Location> vehicleLocationMap;
    SpaceService spaceService = new SpaceService();
    BillService billService = new BillService();
    VehicleService vehicleService;

    public ParkingService(List<Space> parkingSpaceList,VehicleService vehicleService) {
        this.vehicleLocationMap = new HashMap<>();
        this.vehicleService  = vehicleService;
        this.parkingSpaceList = parkingSpaceList;
    }

    public boolean addVehicle(Vehicle vehicle) throws  AccessDeniedException {
        Location location = findLocation(vehicle.getVehicleType());
        vehicleLocationMap.put(vehicle,location);
        location.setAvialability(Avialability.OCCUPIED);
        System.out.println("Added vechile in space");
        return true;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        Location location = vehicleLocationMap.get(vehicle);
        location.setAvialability(Avialability.AVAILABLE);
        vehicleLocationMap.remove(vehicle);
        billService.printBill(vehicle);
        return true;

    }

    private Location findLocation(VehicleType vehicleType) throws AccessDeniedException {
        for(int i=0;i<parkingSpaceList.size();i++) {
            Space space = parkingSpaceList.get(i);
            if(space.getVehicleType().equals(vehicleType)&&!space.isFull()) {

                Location location = null;
                try {
                    location = spaceService.getFirstFreeLocation(space);
                } catch (AccessDeniedException e) {

                   System.out.println( e.getMessage());
                   System.out.println("Trying other spaces");
                }
                System.out.println("Adding vehicle in space level "+space.getLevel()+" for vehicle type "+
                        space.getVehicleType().toString()+" at position "+location.getLocationPosition());
                return location;
            }
        }
        throw new AccessDeniedException("No space Available. Sorry");
    }
}
