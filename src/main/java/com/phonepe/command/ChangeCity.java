package com.phonepe.command;

import com.phonepe.location.LocationService;

public class ChangeCity implements Command {
    private final LocationService locationService;
    private final String cabId;
    private final String city;

    public ChangeCity(LocationService locationService, String cabId, String city) {
        this.locationService = locationService;
        this.cabId = cabId;
        this.city = city;
    }

    @Override
    public String execute() {
        boolean result = locationService.changeCity(cabId, city);
        if (result) {
            return "Successfully changed city";
        }
        return "Failed to change city";
    }
}
