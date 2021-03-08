package com.phonepe.location;

import com.phonepe.Cab;
import com.phonepe.allocation.CabAllocator;

import java.util.HashMap;
import java.util.Map;

public class LocationService {
    private Map<String, String> cityToStates;
    private CabAllocator cabAllocator;

    public LocationService(CabAllocator cabAllocator) {
        this.cabAllocator = cabAllocator;
        cityToStates = new HashMap<>();
    }

    public void register(Cab cab) {
        cabAllocator.registerCab(cab, cab.getCity());
    }

    public boolean changeCity(Cab cab, String city) {
        if (city.equals(cab.getCity())) {
            return true;
        }
        if (!cityToStates.containsKey(city)) {
            throw new IllegalArgumentException("City no serviceable");
        }
        cabAllocator.deregisterCab(cab, cab.getCity());
        cab.setCity(city);
        cabAllocator.registerCab(cab, city);
        return true;
    }
}
