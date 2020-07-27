package mohit.learn.java;

import mohit.learn.java.model.Cab;
import mohit.learn.java.model.Driver;
import mohit.learn.java.model.Location;
import mohit.learn.java.service.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        CabService cabService = new CabService();
        LocationService locationService = new LocationService();
        Cab cab1 = new Cab(new Location(10,11),"134",new Driver("Mohit","DKFJ"));
        Cab cab2 = new Cab(new Location(12,10),"1234",new Driver("Rohit","DKFJ"));
        Cab cab3 = new Cab(new Location(134,100),"3490",new Driver("Raj","DKFJ"));

        cabService.addCab(cab1);
        cabService.addCab(cab2);
        cabService.addCab(cab3);

        CabBookingInterface ui = new CabBookingInterface(new SearchService(cabService,locationService),new FareService(locationService),new JourneyService());
        ui.loadUI();
    }
}
