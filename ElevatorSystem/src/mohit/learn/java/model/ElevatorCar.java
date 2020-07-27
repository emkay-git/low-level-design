package mohit.learn.java.model;

import mohit.learn.java.enums.Direction;
import mohit.learn.java.enums.LiftStatus;

public class ElevatorCar {

    private int currentFloor;
    private Direction currentDirection;
    private int personCount;
    private LiftStatus liftStatus;

    public ElevatorCar(int currentFloor, Direction currentDirection, int personCount) {
        this.currentFloor = currentFloor;
        this.currentDirection = currentDirection;
        this.personCount = personCount;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public LiftStatus getLiftStatus() {
        return liftStatus;
    }

    public void setLiftStatus(LiftStatus liftStatus) {
        this.liftStatus = liftStatus;
    }
}
