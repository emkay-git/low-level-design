package mohit.learn.java.service;

import mohit.learn.java.enums.JourneyStatus;
import mohit.learn.java.model.*;

public class JourneyService {



    public JourneyService() {
    }

    public Journey startJourney(Location startLocation, Location endLocation, Person person, Cab cabUsed) throws InterruptedException {
        Journey journey = new Journey(startLocation,endLocation,cabUsed,person);
        Thread.sleep(5000);
        return journey;
    }


    public Journey endJourney(Journey journey) {
        journey.setTimeOfCompletion(System.currentTimeMillis());
        journey.setJourneyStatus(JourneyStatus.COMPLETED);
        return journey;
    }


}
