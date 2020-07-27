package mohit.learn.java.service;

import mohit.learn.java.model.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlayerService {

    Queue<Player> playerQueue = new LinkedList<Player>();

    public PlayerService(List<String> playerList) {
        createPlayer(playerList).forEach(player -> playerQueue.add(player));
    }

    private List<Player> createPlayer(List<String> player) {
        List<Player> playerList = new ArrayList<>();
        for(int i=0;i<player.size();i++) {
            Player tempPlayer = new Player(player.get(i),i);
            playerList.add(tempPlayer);
        }
        return playerList;
    }

    public Player getNextPlayer() {
        Player currentPlayer = playerQueue.poll();
        playerQueue.add(currentPlayer);
        return currentPlayer;
    }

    public int getPlayersCount() {
        return this.playerQueue.size();
    }
}
