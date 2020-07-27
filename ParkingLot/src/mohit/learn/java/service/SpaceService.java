package mohit.learn.java.service;

import mohit.learn.java.enums.Avialability;
import mohit.learn.java.model.Location;
import mohit.learn.java.model.Space;

import java.nio.file.AccessDeniedException;
import java.util.List;

public class SpaceService {

    public Location getFirstFreeLocation(Space space) throws AccessDeniedException {
        List<Location> locationList = space.getLocationList();
        for(int i=0;i<locationList.size();i++) {
            if(locationList.get(i).getAvialability().equals(Avialability.AVAILABLE)) return locationList.get(i);
        }
        space.setFull(true);
        throw new AccessDeniedException("No Free Space in this space");
    }
}
