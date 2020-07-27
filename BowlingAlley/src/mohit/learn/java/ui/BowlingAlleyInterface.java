package mohit.learn.java.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BowlingAlleyInterface {

    BufferedReader br;

    public BowlingAlleyInterface() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public List<String> getPlayerInput() throws IOException {
        System.out.println("Enter players count followed by names in new lines");
        int playerCount = Integer.parseInt(br.readLine());
        List<String> playerNames = new ArrayList<>();
        while(playerCount-->0) {
            String name = br.readLine();
            playerNames.add(name);
        }

        return playerNames;
    }
}
