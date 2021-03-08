package com.phonepe.command;

import com.phonepe.location.LocationService;
import com.phonepe.models.Cab;

public class RegisterCab implements Command {
    private final LocationService locationService;
    private final String cabId;
    private final String city;

    public RegisterCab(LocationService locationService, String cabId, String city) {
        this.locationService = locationService;
        this.cabId = cabId;
        this.city = city;
    }

    @Override
    public String execute() {
        Cab cab = new Cab(cabId);
        locationService.register(cab, city);
        return String.format("Cab %s is registered for city %s", cabId, city);
    }
}
