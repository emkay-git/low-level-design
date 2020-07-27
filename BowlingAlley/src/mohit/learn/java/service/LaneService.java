package mohit.learn.java.service;

import mohit.learn.java.model.Lane;

public class LaneService {

    Lane laneOccupied[];
    public LaneService(int count) {
        laneOccupied = new Lane[count];
        for(int i=0;i<count;i++) {
            Lane tempLane = new Lane(i);
            laneOccupied[i] = tempLane;
        }
    }

    public Lane isLaneAvailable() throws IllegalAccessException {
        for(int i=0;i<laneOccupied.length;i++) {
            if(!laneOccupied[i].isOccupied()) {
                return laneOccupied[i];
            }
        }
        throw new IllegalAccessException("");
    }

}
