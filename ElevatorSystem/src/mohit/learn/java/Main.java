package mohit.learn.java;

import mohit.learn.java.service.ElevatorService;
import mohit.learn.java.service.FloorService;
import mohit.learn.java.ui.LiftUI;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Problem Statement
 * You should define a lift which can go upto MAX_FLOOR number of floors.
 * Person should be able to enter and exit at any floor
 * Person should be able to choose the floor where it wants to reach.
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        FloorService fs = new FloorService(10);
        LiftUI liftUI = new LiftUI(fs);


        new Thread(new ElevatorService(fs)).start();

        System.out.println("HERE");
        try {
            liftUI.takeInput();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
