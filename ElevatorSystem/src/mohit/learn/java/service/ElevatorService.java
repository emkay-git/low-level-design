package mohit.learn.java.service;

import mohit.learn.java.enums.Direction;
import mohit.learn.java.enums.LiftStatus;
import mohit.learn.java.model.ElevatorCar;


public class ElevatorService implements Runnable {

    ElevatorCar elevatorCar;
    FloorService floorService;

    public ElevatorService(FloorService floorService) {
        this.floorService = floorService;
        elevatorCar = new ElevatorCar(1,null,0);
    }

    public void stopLift() {
        try {
            Thread.sleep(1000);
            System.out.println("Stopping lift at "+ (this.elevatorCar.getCurrentFloor()));
            this.floorService.unsetStopForElevator(this.elevatorCar.getCurrentFloor());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void computeNextStop() {

        while(true) {
            System.out.println("Computing Next Event");
            this.elevatorCar.setLiftStatus(LiftStatus.STOPPED);
            try {
                 int currentFloor = this.elevatorCar.getCurrentFloor();
                 for(int i=currentFloor;i<this.floorService.getMaxFloor();i++) {
                     if(this.floorService.shouldStop(i)) {
                         this.elevatorCar.setCurrentDirection(Direction.UP);
                         this.elevatorCar.setLiftStatus(LiftStatus.RUNNING);
                         this.moveLift();
                     }
                 }

                for(int i=1;i<this.elevatorCar.getCurrentFloor();i++) {
                    if(this.floorService.shouldStop(i)) {
                        this.elevatorCar.setCurrentDirection(Direction.DOWN);
                        this.elevatorCar.setLiftStatus(LiftStatus.RUNNING);
                        this.moveLift();
                    }
                }
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void moveLift() {
        while(this.elevatorCar.getCurrentDirection()==Direction.DOWN) {
            System.out.println("Lift is going DOWN");
            try {
                if(!this.downFloor()) break;
                Thread.sleep(4000);

                if(this.floorService.shouldStop(this.elevatorCar.getCurrentFloor())) {

                    this.stopLift();
                } else Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while(this.elevatorCar.getCurrentDirection()==Direction.UP) {
            System.out.println("Lift is going UP");
            try {
                if(!this.upFloor()) {
                    System.out.println("Reached TOP");
                    break;
                }

                Thread.sleep(4000);
                if(this.floorService.shouldStop(this.elevatorCar.getCurrentFloor())) {
                    this.stopLift();
                } else Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Exit");
    }


    public boolean upFloor() {
        System.out.println(this.elevatorCar.getCurrentFloor());
        if(this.elevatorCar.getCurrentFloor()+1==this.floorService.getMaxFloor()) return false;

        this.elevatorCar.setCurrentFloor(this.elevatorCar.getCurrentFloor()+1);
        return true;
    }

    public boolean downFloor() {
        if(this.elevatorCar.getCurrentFloor()-1 == 0 ) return false;
        this.elevatorCar.setCurrentFloor(this.elevatorCar.getCurrentFloor()-1);
        return true;
    }


    @Override
    public void run() {
        System.out.println("oka");
        this.computeNextStop();
    }
}


// direction change -
// halt function - (just before reaching a floor)
// path update - stop
// when stop - check if I have to up.