package com.phonepe;

import lombok.Data;

import java.util.Date;

@Data
public class Cab {
    private String cabId;
    private CabState cabState;
    private String city;
    private String state;
    private Date availableFrom;

    public void changeState(CabState cabState) {
        this.cabState = cabState;
        if (cabState == CabState.IDLE) {
            availableFrom = new Date();
        }
    }
}
