package mohit.learn.java.service;

import mohit.learn.java.enums.CabStatus;
import mohit.learn.java.model.Cab;
import mohit.learn.java.model.Location;

import java.util.List;

public class SearchService {

    List<Cab> cabList;
    LocationService locationService;
    public SearchService(CabService cabService, LocationService locationService) {
        this.locationService = locationService;
        cabList = cabService.getAllCabs();
    }

    public Cab findCab(Location userLocation) {
        int shortestDistance = Integer.MAX_VALUE;
        Cab availableCab = null;
        for(int i=0;i<cabList.size();i++) {
            if(cabList.get(i).getCabStatus().equals(CabStatus.ONLINE)) {
                int distance =  this.locationService.calculateDistance(cabList.get(i).getCabLocation(),userLocation);
                if(distance<shortestDistance) {
                    shortestDistance = distance;
                    availableCab = cabList.get(i);
                }
            }

        }

        return availableCab;
    }

}
