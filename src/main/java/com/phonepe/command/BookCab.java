package com.phonepe.command;

import com.phonepe.allocation.CabAllocator;

import java.util.Optional;

public class BookCab implements Command {
    private final CabAllocator cabAllocator;
    private final String city;

    public BookCab(CabAllocator cabAllocator, String city) {
        this.cabAllocator = cabAllocator;
        this.city = city;
    }

    @Override
    public String execute() {
        Optional<String> cabIdOptional = cabAllocator.bookCab(city);
        if (!cabIdOptional.isPresent()) {
            return "No Cab is available to book";
        }
        String cabId = cabIdOptional.get();
        return String.format("Can booked with ID %s", cabId);
    }
}
