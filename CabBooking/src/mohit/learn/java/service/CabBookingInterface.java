package mohit.learn.java.service;

import mohit.learn.java.model.Cab;
import mohit.learn.java.model.Journey;
import mohit.learn.java.model.Location;
import mohit.learn.java.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CabBookingInterface {

    BufferedReader br;

    SearchService searchService;
    FareService fareService;
    JourneyService journeyService;

    public CabBookingInterface(SearchService searchService, FareService fareService, JourneyService journeyService) {
        this.searchService = searchService;
        this.fareService = fareService;
        this.journeyService = journeyService;
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void loadUI() throws IOException, InterruptedException {
        int n = 4;

        while(n-->0) {
           String input[] =  br.readLine().split(" ");
           String name = input[0];
           Person person = new Person(name);
           Location startLocation = new Location(Integer.parseInt(input[1]),Integer.parseInt(input[2]));
           Location endLocation = new Location(Integer.parseInt(input[3]),Integer.parseInt(input[4]));

            Cab cabUsed = this.searchService.findCab(startLocation);
            Journey newJourney = this.journeyService.startJourney(startLocation,endLocation,person,cabUsed);
            newJourney = this.journeyService.endJourney(newJourney);
            this.fareService.calculateFare(newJourney);
        }
    }
}
