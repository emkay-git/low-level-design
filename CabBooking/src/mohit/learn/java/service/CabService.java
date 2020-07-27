package mohit.learn.java.service;

import mohit.learn.java.model.Cab;

import java.util.ArrayList;
import java.util.List;

public class CabService {

    private List<Cab> cabList;

    public CabService() {
        cabList = new ArrayList<>();
    }

    public void addCab(Cab cab) {
        cabList.add(cab);
    }

    public List<Cab> getAllCabs() {
        return cabList;
    }

}
