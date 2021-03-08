package com.phonepe.reader;

import com.phonepe.allocation.CabAllocator;
import com.phonepe.command.Command;
import com.phonepe.command.ExitCommand;
import com.phonepe.command.RegisterCab;
import com.phonepe.location.LocationService;

import java.util.UUID;

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
            default:
                return new ExitCommand();
        }
    }
}
