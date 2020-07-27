package mohit.learn.java.model;

import mohit.learn.java.enums.Avialability;

public class Location {
    int locationPosition;
    Avialability avialability;

    public Location(int locationPosition) {
        this.locationPosition = locationPosition;
        this.avialability = Avialability.AVAILABLE;
    }

    public int getLocationPosition() {
        return locationPosition;
    }

    public void setLocationPosition(int locationPosition) {
        this.locationPosition = locationPosition;
    }

    public Avialability getAvialability() {
        return avialability;
    }

    public void setAvialability(Avialability avialability) {
        this.avialability = avialability;
    }
}
