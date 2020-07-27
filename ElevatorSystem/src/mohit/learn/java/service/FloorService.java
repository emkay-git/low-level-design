package mohit.learn.java.service;

import java.util.concurrent.CopyOnWriteArrayList;

public class FloorService {

    private CopyOnWriteArrayList<Boolean> elevatorPath;

    public FloorService(int floorCount) {
        elevatorPath = new CopyOnWriteArrayList<>();
        for(int i=0;i<=floorCount;i++) {
            elevatorPath.add(false);
        }
        System.out.println(this.elevatorPath.size());
    }

    public int getMaxFloor() {

        return this.elevatorPath.size();
    }
    /**
     * Function used by elevator car
     */
    public boolean shouldStop(int floorNumber) {
        return this.elevatorPath.get(floorNumber);
    }


    /**
     * Function used by button to stop at a floor
     **/
    public void setStopForElevator(int floorNumber) {
        this.elevatorPath.set(floorNumber,true);
    }

    /**
     * Function used by elevator car.
     * @param floorNumber
     */
    public void unsetStopForElevator(int floorNumber) {
        this.elevatorPath.set(floorNumber,false);
    }
}
