package com.phonepe.command;

import com.phonepe.allocation.CabAllocator;

public class MarkAvailableCab implements Command {
    private final CabAllocator cabAllocator;
    private final String cabId;

    public MarkAvailableCab(CabAllocator cabAllocator, String cabId) {
        this.cabAllocator = cabAllocator;
        this.cabId = cabId;
    }

    @Override
    public String execute() {
        cabAllocator.markAvailable(cabId);
        return String.format("Marked %s as available", cabId);
    }
}
