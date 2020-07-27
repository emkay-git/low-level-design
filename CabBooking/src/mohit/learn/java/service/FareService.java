package mohit.learn.java.service;

import mohit.learn.java.model.Fare;
import mohit.learn.java.model.Journey;
import mohit.learn.java.model.Location;

public class FareService {
    LocationService locationService;
    public FareService(LocationService locationService) {
        this.locationService = locationService;
    }
    public void calculateFare(Journey journey) {
        Location start = journey.getStart();
        Location end = journey.getEnd();

        int distance = this.locationService.calculateDistance(start,end);
        long totalTime = journey.getTimeOfCompletion() - journey.getStartTime();

         printFare(journey,combinedFare(totalTime,distance));
    }

    public Fare combinedFare(long totalTime, int totalDistance) {
        Fare f = new Fare();
        double fare = totalTime*1.5+ totalDistance*60;
        f.setAmount(fare);
        f.setFinalAmount(fare);
        return f;
    }

    public void printFare(Journey journey, Fare fare) {
        journey.setFare(fare);
        System.out.println("Bill is\n "+journey.getPerson().getName()+" "+fare.getFinalAmount());
    }
}
