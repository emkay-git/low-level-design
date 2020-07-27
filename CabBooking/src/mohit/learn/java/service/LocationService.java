package mohit.learn.java.service;

import mohit.learn.java.model.Location;

public class LocationService {

    public int calculateDistance(Location a, Location b) {
        int x1 = a.getLatitude();
        int y1 = a.getLongitude();
        int x2 = b.getLatitude();
        int y2 = b.getLongitude();

        return (int)(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }
}
