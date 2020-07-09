package mohit.learn.java.service;

import mohit.learn.java.model.*;

import java.util.List;

public class GameService {

    GameBoard board;
    Dice dice;
    PlayerService playerService;
    public GameService() {
        dice = new Dice();
        board = new GameBoard();

    }

    public void initBoard(List<Snake> snakes, List<Ladder> ladder) {
        board.initBoard(snakes,ladder);
    }


    public void startGame(List<Player> playerList) {
        playerService = new PlayerService(playerList);
        makeMove();
    }

    private void makeMove() {
        Player currentPlayer = playerService.getNextPlayer();
        int currentPosition = currentPlayer.currentPosition;
        int nextNumber = dice.getNextValue();
        int nextPosition = nextNumber+ currentPosition;

        if(nextPosition == 100) {
            System.out.println("Player "+currentPlayer.name+" is the winner");
            return;
        }
        if(nextPosition<100) {
            int updatedPosition = board.resolveMove(nextPosition);
            currentPlayer.currentPosition = updatedPosition;
            System.out.println("Player "+currentPlayer.name+" moved to "+updatedPosition+" from "+currentPosition);
        }
        playerService.setLastPlayer(currentPlayer);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        makeMove();
    }

}
