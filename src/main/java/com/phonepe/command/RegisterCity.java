package com.phonepe.command;

import com.phonepe.location.LocationService;

public class RegisterCity implements Command {
    private final LocationService locationService;
    private final String city;
    private final String state;

    public RegisterCity(LocationService locationService, String city, String state) {
        this.locationService = locationService;
        this.city = city;
        this.state = state;
    }

    @Override
    public String execute() {
        locationService.registerCity(city, state);
        return String.format("City %s is register for state %s", city, state);
    }
}
