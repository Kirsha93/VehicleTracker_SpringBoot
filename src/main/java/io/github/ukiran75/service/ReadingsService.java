package io.github.ukiran75.service;

import io.github.ukiran75.entity.Reading;
import io.github.ukiran75.entity.Vehicle;

/*
 * Reading Service Interface
 */
public interface ReadingsService {
    void insertReadings(String readings);
    String getReadingsofVehicle(String vin);
    void checkAlerts(Reading reading, Vehicle vehicle);
}
