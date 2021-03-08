package com.phonepe;

import com.phonepe.allocation.CabAllocator;
import com.phonepe.location.LocationService;
import com.phonepe.models.Cab;
import org.junit.Test;

import java.util.Optional;

public class CabApplicationTest {
    @Test
    public void testCabBooking() {
        CabAllocator cabAllocator = new CabAllocator();
        LocationService locationService = new LocationService(cabAllocator);

        locationService.registerCity("Pune", "MH");
        locationService.registerCity("Blr", "KA");

        Cab cab1 = new Cab("1");
        locationService.register(cab1, "Pune");
        waitTime(2);
        Cab cab2 = new Cab("2");
        locationService.register(cab2, "Pune");

        locationService.changeCity(cab2.getCabId(), "Blr");
        System.out.println(cab1);
        System.out.println(cab2);
        waitTime(3);
        Cab cab3 = new Cab("3");
        locationService.register(cab3, "Pune");

        Optional<String> cabIdOptional = cabAllocator.bookCab("Pune");
        if (!cabIdOptional.isPresent()) {
            System.out.println("Sorry Can not available");
            return;
        }
        System.out.println("Booking cab");
        String cabId = cabIdOptional.get();
        System.out.println(cabAllocator.getCab(cabId));
        cabAllocator.markAvailable(cabId);
        System.out.println(cabAllocator.getCab(cabId));
    }

    private static void waitTime(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}