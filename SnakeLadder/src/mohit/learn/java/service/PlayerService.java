package mohit.learn.java.service;

import mohit.learn.java.model.Player;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PlayerService {
    private Deque<Player> playersQueue;


    public PlayerService(List<Player> playerList) {
        playersQueue = new LinkedList<>();
        playerList.forEach(player -> {
            playersQueue.add(player);
        });
    }


    public Player getNextPlayer() {
        return playersQueue.pollFirst();
    }

    public void setLastPlayer(Player player) {
        playersQueue.addLast(player);
    }
}
