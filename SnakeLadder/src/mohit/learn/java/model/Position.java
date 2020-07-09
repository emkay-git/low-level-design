package mohit.learn.java.model;

public class Position {
    private int number;
    private boolean isSnakePresent;
    private boolean isLadderPresent;
    private Snake snake;
    private Ladder ladder;


    public Position(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isSnakePresent() {
        return isSnakePresent;
    }

    public void setSnakePresent(boolean snakePresent) {
        isSnakePresent = snakePresent;
    }

    public boolean isLadderPresent() {
        return isLadderPresent;
    }

    public void setLadderPresent(boolean ladderPresent) {
        this.isLadderPresent = true;
        isLadderPresent = ladderPresent;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.isSnakePresent = true;
        this.snake = snake;
    }


    public Ladder getLadder() {
        return ladder;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }
}
