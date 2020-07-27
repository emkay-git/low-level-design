package mohit.learn.java.service;

import mohit.learn.java.enums.VehicleType;
import mohit.learn.java.model.Bill;
import mohit.learn.java.model.Vehicle;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;

public class BillService {


    public void printBill(Vehicle vehicle) {
        Bill bill = calculateBill(vehicle);

        System.out.println("Invoice Id: "+bill.getInvoiceId()+"\nAmount paid for a vehicle "+
                vehicle.getVehicleNumber()+" is "+bill.getTotalAmount()+" "+
            "for time "+bill.getTotalHourSpend());
    }

    public Bill calculateBill(Vehicle vehicle) {
        int timeSpend = (int)Duration.between(vehicle.getEntryTime(),LocalTime.now()).toSeconds();
        switch (vehicle.getVehicleType()) {
            case LARGE_VEHICLE ->  {return new Bill("ID",timeSpend*200,timeSpend);}
            case SMALL_VEHICLE ->  {return new Bill("ID@",timeSpend*50,timeSpend);}
            case MEDIUM_VEHICLE -> { return new Bill("ID@#",timeSpend*100,timeSpend);}
        }

        throw new IllegalArgumentException("Vehicle type Incorrect");
    }

}
