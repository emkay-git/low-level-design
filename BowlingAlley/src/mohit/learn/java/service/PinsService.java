package mohit.learn.java.service;

import java.util.Random;

public class PinsService {
    Random r;
    int maxPins;
    public PinsService() {
        r = new Random();
        maxPins = 10;
    }

    public int getScore() {
        int val = r.nextInt(maxPins)+1;
        maxPins-=val;
        return val;
    }

    public void resetPins() {
        maxPins = 10;
    }
}
