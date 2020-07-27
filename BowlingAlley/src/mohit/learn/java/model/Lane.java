package mohit.learn.java.model;

public class Lane {
    private int laneNumber;
    private boolean isOccupied;

    public Lane(int laneNumber) {
        laneNumber = laneNumber;
        isOccupied = false;
    }
    public int getLaneNumber() {
        return laneNumber;
    }

    public void setLaneNumber(int laneNumber) {
        this.laneNumber = laneNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

}
