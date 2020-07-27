package mohit.learn.java.service;

import mohit.learn.java.model.Lane;
import mohit.learn.java.model.Player;

import java.util.HashMap;
import java.util.Map;

public class GameService {

    PlayerService playerService;
    LaneService laneService;
    PinsService pinsService;
    Lane currentLane;
    Map<Player,Integer> map;

    public GameService(PlayerService playerService,LaneService laneService) {
        this.playerService = playerService;
        this.laneService = laneService;
        this.pinsService = new PinsService();
        map = new HashMap<>();
    }

    public void startGame(int rounds) {
        try {
            currentLane = this.laneService.isLaneAvailable();
            currentLane.setOccupied(true);
            for(int i=0;i<rounds;i++) {
                play();
                displayScore(i+1);
            }
            System.out.println("Winnder is "+getMaxScorePlayerName());
            currentLane.setOccupied(false);

        } catch (IllegalAccessException e) {
            System.out.println("Cannot start game");
            e.printStackTrace();
        }

    }

    private String getMaxScorePlayerName() {
        int max = 0;
        Player winner = null;
        for(Map.Entry<Player,Integer> map: map.entrySet()) {
            if(max<=map.getValue()) {
                max = map.getValue();
                winner = map.getKey();
            }
        }
        return winner.getName();
    }

    private void play() {
        int playerCount = playerService.getPlayersCount();
        for(int i=0;i<playerCount;i++) {
            Player currentPlayer = playerService.getNextPlayer();
            map.putIfAbsent(currentPlayer,0);
            int prevGamesScore = map.get(currentPlayer);
            int score = pinsService.getScore();
            int score2 = 0;

            if(score!=10) {
               score2 = pinsService.getScore();

            }

            map.put(currentPlayer,prevGamesScore+score+score2);

            pinsService.resetPins();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void displayScore(int roundNumber) {
        System.out.println("Scores after Round "+roundNumber);
        map.forEach((player,score) -> {
            System.out.println(player.getName()+" scored "+score);
        });
    }

}
