package com.phonepe.allocation;

import com.phonepe.Cab;
import com.phonepe.CabState;

public class IdleTimeStrategy implements AllocationStrategy {
    @Override
    public int compare(Cab cab1, Cab cab2) {
        CabState cab1State = cab1.getCabState();
        CabState cab2State = cab2.getCabState();
        if (cab1State == CabState.IDLE && cab2State == CabState.IDLE) {
            return cab1.getAvailableFrom().compareTo(cab2.getAvailableFrom());
        } else if (cab1State == CabState.IDLE || cab2State == CabState.IDLE) {
            return cab1State == CabState.IDLE ? -1 : 1;
        }
        return 0;
    }
}
