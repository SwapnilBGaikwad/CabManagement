package com.phonepe.allocation;

import com.phonepe.Cab;
import com.phonepe.CabState;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CabAllocator {
    private Map<String, PriorityQueue<Cab>> cityToAvailableCabs;
    private Map<String, Cab> cabIdToBusyCabs;

    public CabAllocator() {
        this.cityToAvailableCabs = new HashMap<>();
        this.cabIdToBusyCabs = new HashMap<>();
    }

    public boolean registerCab(Cab cab, String city) {
        PriorityQueue<Cab> cabs = cityToAvailableCabs.getOrDefault(city, new PriorityQueue<>());
        if (cabs.isEmpty()) {
            cityToAvailableCabs.put(city, cabs);
        }
        cabs.add(cab);
        cab.changeState(CabState.IDLE);
        return true;
    }

    public void deregisterCab(Cab cab, String city) {
        PriorityQueue<Cab> cabs = cityToAvailableCabs.get(city);
        cabs.remove(cab);
    }
}
