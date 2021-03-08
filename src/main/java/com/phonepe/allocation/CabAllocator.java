package com.phonepe.allocation;

import com.phonepe.models.Cab;
import com.phonepe.models.CabState;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;

public class CabAllocator {
    private Map<String, PriorityQueue<Cab>> cityToAvailableCabs;
    private Map<String, Cab> cabIdToCabs;

    public CabAllocator() {
        this.cityToAvailableCabs = new HashMap<>();
        this.cabIdToCabs = new HashMap<>();
    }

    public boolean registerCab(Cab cab, String city) {
        cabIdToCabs.put(cab.getCabId(), cab);
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
        cabIdToCabs.remove(cab.getCabId());
    }

    public Optional<String> bookCab(String city) {
        PriorityQueue<Cab> availableCabs = cityToAvailableCabs.get(city);
        if (availableCabs.isEmpty()) {
            return Optional.empty();
        }
        Cab cab = availableCabs.remove();
        cab.setCabState(CabState.ON_TRIP);
        return Optional.of(cab.getCabId());
    }

    public boolean markAvailable(String cabId) {
        if (!cabIdToCabs.containsKey(cabId)) {
            return false;
        }
        Cab cab = cabIdToCabs.get(cabId);
        PriorityQueue<Cab> availableCabs = cityToAvailableCabs.get(cab.getCity());
        availableCabs.add(cab);
        cab.setCabState(CabState.IDLE);
        return true;
    }

    public Cab getCab(String cabId) {
        return cabIdToCabs.get(cabId);
    }
}
