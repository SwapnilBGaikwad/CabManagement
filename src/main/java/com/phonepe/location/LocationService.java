package com.phonepe.location;

import com.phonepe.models.Cab;
import com.phonepe.allocation.CabAllocator;

import java.util.HashMap;
import java.util.Map;

public class LocationService {
    private final Map<String, String> cityToStates;
    private final CabAllocator cabAllocator;

    public LocationService(CabAllocator cabAllocator) {
        this.cabAllocator = cabAllocator;
        this.cityToStates = new HashMap<>();
    }

    public void register(Cab cab, String city) {
        if (!cityToStates.containsKey(city)) {
            throw new IllegalArgumentException("City not serviceable");
        }
        cab.setCity(city);
        cab.setState(cityToStates.get(city));
        cabAllocator.registerCab(cab, city);
    }

    public boolean changeCity(String cabId, String city) {
        if (!cityToStates.containsKey(city)) {
            return false;
        }
        Cab cab = cabAllocator.getCab(cabId);
        if (city.equals(cab.getCity())) {
            return true;
        }
        cabAllocator.deregisterCab(cab, cab.getCity());
        cab.setCity(city);
        cab.setState(cityToStates.get(city));
        cabAllocator.registerCab(cab, city);
        return true;
    }

    public void registerCity(String city, String state) {
        cityToStates.put(city, state);
    }
}
