package mohit.learn.java.model;

import java.util.Random;

public class Dice {
    private Random random;

    public Dice() {
        random = new Random();
    }

    public int getNextValue() {

       int value =  random.nextInt(6)+1;
       System.out.println("Dice value is "+value);
       return value;
    }
}
