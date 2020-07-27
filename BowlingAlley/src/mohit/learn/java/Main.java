package mohit.learn.java;

import mohit.learn.java.service.GameService;
import mohit.learn.java.service.LaneService;
import mohit.learn.java.service.PlayerService;
import mohit.learn.java.ui.BowlingAlleyInterface;

import java.io.IOException;

public class Main { 

    public static void main(String[] args) throws IOException {

        BowlingAlleyInterface ui = new BowlingAlleyInterface();
        PlayerService playerService = new PlayerService(ui.getPlayerInput());
        LaneService laneService = new LaneService(10);
        GameService gs = new GameService(playerService,laneService);
        System.out.println("Starting Game");
        gs.startGame(10);
        System.out.println("Thanks for playing");

    }
}
