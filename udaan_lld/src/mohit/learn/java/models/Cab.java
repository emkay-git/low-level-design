package mohit.learn.java.models;

public class Driver {

    String name;
    String license;
    Car carDetails;
    Location location;

    public Driver(String name, String license, Car carDetails,Location location) {
        this.name = name;
        this.license = license;
        this.carDetails = carDetails;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Car getCarDetails() {
        return carDetails;
    }

    public void setCarDetails(Car carDetails) {
        this.carDetails = carDetails;
    }
}
