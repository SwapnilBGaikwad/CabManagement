package com.phonepe.reader;

import com.phonepe.allocation.CabAllocator;
import com.phonepe.command.*;
import com.phonepe.location.LocationService;

public class CommandFactory {
    private CabAllocator cabAllocator;
    private LocationService locationService;

    public CommandFactory(CabAllocator cabAllocator, LocationService locationService) {
        this.cabAllocator = cabAllocator;
        this.locationService = locationService;
    }

    public Command create(String instruction) {
        final String[] params = instruction.split(" ");
        String command = params[0];
        switch (command) {
            case "register_cab":
                String cabId = params[1];
                String city = params[2];
                return new RegisterCab(locationService, cabId, city);
            case "register_location":
                city = params[1];
                String state = params[2];
                return new RegisterCity(locationService, city, state);
            case "change_city":
                cabId = params[1];
                city = params[2];
                return new ChangeCity(locationService, cabId, city);
            case "book_cab":
                city = params[1];
                return new BookCab(cabAllocator, city);
            case "mark_available":
                cabId = params[1];
                return new MarkAvailableCab(cabAllocator, cabId);
            default:
                return new ExitCommand();
        }
    }
}
