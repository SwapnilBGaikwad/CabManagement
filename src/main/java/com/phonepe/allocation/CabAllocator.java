package com.phonepe.allocation;

import com.phonepe.Cab;
import com.phonepe.CabState;

import java.util.Map;
import java.util.PriorityQueue;

public class CabAllocator {
    private PriorityQueue<Cab> availableCabs;
    private Map<String, Cab> busyCabs;

    public CabAllocator(AllocationStrategy strategy) {
        this.availableCabs = new PriorityQueue<>(new IdleTimeStrategy());
    }

    void registerCab(Cab cab) {
        availableCabs.add(cab);
        cab.changeState(CabState.IDLE);
    }

    
}
