package com.phonepe.allocation;

import com.phonepe.Cab;
import com.phonepe.CabState;
import com.phonepe.repository.CityRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CabAllocator {
    private Map<String, PriorityQueue<Cab>> cityToAvailableCabs;
    private Map<String, Cab> cabIdToBusyCabs;
    private CityRepository cityRepository;

    public CabAllocator(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
        this.cityToAvailableCabs = new HashMap<>();
        this.cabIdToBusyCabs = new HashMap<>();
    }

    public boolean registerCab(Cab cab) {
        if (!cityRepository.isValidCity(cab.getCity())) {
            return false;
        }
        cab.changeState(CabState.IDLE);
        return true;
    }
}
