package com.phonepe.models;

import lombok.Data;

import java.util.Date;

@Data
public class Cab implements Comparable<Cab> {
    private String cabId;
    private CabState cabState;
    private String city;
    private String state;
    private Date availableFrom;

    public Cab(String cabId) {
        this.cabId = cabId;
        this.availableFrom = new Date();
        this.cabState = CabState.IDLE;
    }

    public void changeState(CabState cabState) {
        this.cabState = cabState;
        if (cabState == CabState.IDLE) {
            availableFrom = new Date();
        }
    }

    @Override
    public int compareTo(Cab other) {
        CabState cab1State = getCabState();
        CabState cab2State = other.getCabState();
        if (cab1State == CabState.IDLE && cab2State == CabState.IDLE) {
            return getAvailableFrom().compareTo(other.getAvailableFrom());
        } else if (cab1State == CabState.IDLE || cab2State == CabState.IDLE) {
            return cab1State == CabState.IDLE ? -1 : 1;
        }
        return 0;
    }
}
