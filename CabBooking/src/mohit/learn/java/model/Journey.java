package mohit.learn.java.model;

import mohit.learn.java.enums.JourneyStatus;

public class Journey {
    Location start;
    Location end;
    Cab cabUsed;
    Person person;
    JourneyStatus journeyStatus;
    Fare fare;

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    long timeOfCompletion;
    long startTime;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getTimeOfCompletion() {
        return timeOfCompletion;
    }

    public void setTimeOfCompletion(long timeOfCompletion) {
        this.timeOfCompletion = timeOfCompletion;
    }


    public JourneyStatus getJourneyStatus() {
        return journeyStatus;
    }

    public void setJourneyStatus(JourneyStatus journeyStatus) {
        this.journeyStatus = journeyStatus;
    }

    public Journey(Location start, Location end, Cab cabUsed, Person person) {
        this.start = start;
        this.end = end;
        this.cabUsed = cabUsed;
        this.person = person;
        this.journeyStatus = JourneyStatus.STARTED;
        this.timeOfCompletion = System.currentTimeMillis();
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getEnd() {
        return end;
    }

    public void setEnd(Location end) {
        this.end = end;
    }

    public Cab getCabUsed() {
        return cabUsed;
    }

    public void setCabUsed(Cab cabUsed) {
        this.cabUsed = cabUsed;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
