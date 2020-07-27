package mohit.learn.java.model;

public class Player {
    private String name;
    private int id;
    private int score;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        this.score = 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
