package mohit.learn.java.model;

import java.util.Objects;

public class Floor {

    private int floorNumber;
    private boolean isLast;
    private boolean isFirst;

    public Floor(int floorNumber, boolean isLast, boolean isFirst) {
        this.floorNumber  = floorNumber;
        this.isLast = isLast;
        this.isFirst = isFirst;
    }
    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Floor)) return false;
        Floor floor = (Floor) o;
        return floorNumber == floor.floorNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(floorNumber);
    }
}
