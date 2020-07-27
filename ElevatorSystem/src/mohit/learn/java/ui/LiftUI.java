package mohit.learn.java.ui;

import mohit.learn.java.model.Floor;
import mohit.learn.java.service.FloorService;
import mohit.learn.java.service.ElevatorService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LiftUI {

    BufferedReader br;
    FloorService floorService;
    public  LiftUI(FloorService floorService) {
        this.floorService = floorService;
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void takeInput() throws IOException {
        String event;
        System.out.println("KDJF");
        while(true) {
            event = br.readLine();
            runEvents(event);
        }
    }


    private void runEvents(String event) {
      processRequest(event);
    }


    private void processRequest(String event) {
        String requestId = event.split(" ")[0];
        switch(requestId) {
            case "CALL":

            case "STOP": {
                System.out.println("TAking input");
                int floorNumber = Integer.parseInt(event.split(" ")[1]);
                this.floorService.setStopForElevator(floorNumber);
                break;
            }
        }

    }
}
