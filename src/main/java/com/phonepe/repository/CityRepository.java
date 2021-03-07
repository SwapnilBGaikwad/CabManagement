package com.phonepe.repository;

import java.util.Set;

public class CityRepository {
    private Set<String> validCities;

    public void register(String city) {
        validCities.add(city);
    }

    public boolean isValidCity(String city) {
        return validCities.contains(city);
    }
}
