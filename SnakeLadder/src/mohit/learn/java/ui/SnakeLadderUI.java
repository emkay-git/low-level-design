package mohit.learn.java.ui;

import mohit.learn.java.model.Ladder;
import mohit.learn.java.model.Player;
import mohit.learn.java.model.Snake;
import mohit.learn.java.service.GameService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SnakeLadderUI {
    private BufferedReader br;
    private GameService gameService;
    public void loadUI() {
        gameService = new GameService();
       br  = new BufferedReader(new InputStreamReader(System.in));
    }

    public void takeInput() throws IOException {


        gameService.initBoard( this.inputSnakes(),this.inputLadder());
        gameService.startGame( this.inputPlayer());
    }

    public List<Snake> inputSnakes() throws IOException {
        System.out.println("Enter Snakes count");
        int snakes = Integer.parseInt(br.readLine());

        List<Snake> snakeList = new ArrayList<>();

        while(snakes-->0) {

            String temp[] = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            if(end>=start) throw new IllegalArgumentException();
            Snake snake = new Snake();
            snake.start = start;
            snake.end = end;
            snakeList.add(snake);
        }
        return snakeList;
    }

    public List<Ladder> inputLadder() throws IOException {
        System.out.println("Enter Ladder Count");
        int ladderCount = Integer.parseInt(br.readLine());

        List<Ladder> ladderList = new ArrayList<>();

        while(ladderCount-->0) {

            String temp[] = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            if(end<=start) throw new IllegalArgumentException();
            Ladder ladder = new Ladder();
            ladder.start = start;
            ladder.end = end;
            ladderList.add(ladder);
        }
        return ladderList;
    }

    public List<Player> inputPlayer() throws IOException {
        System.out.println("Enter Player Count");
        int playerCount = Integer.parseInt(br.readLine());
        System.out.println("Enter Players");
        List<Player> playerList = new ArrayList<>();

        while(playerCount-->0) {

            String temp[] = br.readLine().split(" ");
            Player player = new Player();
            player.name = temp[1];
            player.id =temp[0];
            playerList.add(player);
        }
        return playerList;
    }
}
/**
 3
 10 3
 20 5
 98 25
 *
 * 2
 * 1 99
 * 30 80
 *
 * 1 Rohit
 * 2 Mohit
 */
