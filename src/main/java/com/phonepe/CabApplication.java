package com.phonepe;

import com.phonepe.allocation.CabAllocator;
import com.phonepe.location.LocationService;
import com.phonepe.reader.CommandFactory;
import com.phonepe.reader.CommandReader;

import java.io.*;

public class CabApplication {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader;
        if (args.length == 1) {
            bufferedReader = new BufferedReader(new FileReader(args[0]));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }
        CabAllocator cabAllocator = new CabAllocator();
        LocationService locationService = new LocationService(cabAllocator);
        final CommandFactory factory = new CommandFactory(cabAllocator, locationService);
        CommandReader commandReader = new CommandReader(bufferedReader, factory);
        CabAllocationExecutor executor = new CabAllocationExecutor(commandReader);
        executor.execute();
    }
}
