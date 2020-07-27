package mohit.learn.java.model;

public class Driver {
    private String name;
    private String driverLicense;

    public Driver(String name, String driverLicense) {
        this.name = name;
        this.driverLicense = driverLicense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }


}
