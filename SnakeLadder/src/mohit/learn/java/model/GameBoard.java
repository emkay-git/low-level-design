package mohit.learn.java.model;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    List<Position> gameBoard;

    public GameBoard() {
       gameBoard = new ArrayList<>();
    }

    public boolean initBoard(List<Snake> snakes, List<Ladder> ladder) {
        for(int i=1;i<=100;i++) {
            Position p = new Position(i);
            gameBoard.add(p);
        }
        return addSnakesToBoard(snakes)&&addLadderToBoard(ladder);
    }

    private boolean addSnakesToBoard(List<Snake> snakes) {

        for(int i=0;i<snakes.size();i++) {
            int start = snakes.get(i).start;
            int end = snakes.get(i).end;

            Position gamePosition = gameBoard.get(start);

            //checks cycle
            if(
                    gamePosition.isLadderPresent() &&
                    gamePosition.getLadder().start==end &&
                    gamePosition.getLadder().end == start
            )
                return false;

            gamePosition.setSnake(snakes.get(i));

        }

        return true;
    }

    private boolean addLadderToBoard(List<Ladder> ladder) {
        for(int i=0;i<ladder.size();i++) {
            int start = ladder.get(i).start;
            int end = ladder.get(i).end;

            Position gamePosition = gameBoard.get(start);

            //checks cycle
            if(
                    gamePosition.isSnakePresent() &&
                            gamePosition.getSnake().start==end &&
                            gamePosition.getSnake().end == start
            )
                return false;

            gamePosition.setLadder(ladder.get(i));

        }
        return true;
    }

    public int resolveMove(int index) {
        Position position = gameBoard.get(index);
        if(position.isSnakePresent()) {
            return resolveMove(position.getSnake().end);
        }
        if(position.isLadderPresent()) {
            return resolveMove(position.getLadder().end);
        }

        return index;
    }
}
