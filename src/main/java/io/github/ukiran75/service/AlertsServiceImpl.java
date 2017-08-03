package io.github.ukiran75.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.ukiran75.entity.Alert;
import io.github.ukiran75.entity.VehicleAlerts;
import io.github.ukiran75.exception.ResourceNotFoundException;
import io.github.ukiran75.repository.AlertsRepository;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class implementing the AlertsService
 */
@Service
public class AlertsServiceImpl implements AlertsService {

    @Autowired
    AlertsRepository alertsRepository;

    /**
     * Method to insert the alert which will call the
     * insertalert method in alertsRepository.
     * @param alert
     */
    public void insertAlert(Alert alert) {
        alertsRepository.save(alert);

    }


    /**
     * Method to get all alerts of all the vehicles along
     * with the count of alerts for each vehicle
     * @return Json String of all alerts
     */
    public String getAllAlertsofVehicles(){
        List<Object> alerts = alertsRepository.finAlerts();
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleAlerts> allVehicleAlerts = new ArrayList<VehicleAlerts>();
        for (Object a: alerts){
            Object[] objects = (Object[]) a;
            VehicleAlerts al = new VehicleAlerts((String)objects[0],Math.toIntExact((long)objects[1])) ;
            allVehicleAlerts.add(al);
        }

        try {
            return mapper.writeValueAsString(allVehicleAlerts);
        } catch (JsonProcessingException e) {
            throw new ResourceNotFoundException("Alerts data is not in valid format");
        }

    }

    /**
     * Method to get all the alerts of a vehicle
     *
     * @param vin
     * @return String of alerts
     */
    public String getAlertsofVehicle(String vin) {
        List<Alert> alerts = alertsRepository.findAllByVin(vin);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(alerts);
        } catch (JsonProcessingException e) {
            throw new ResourceNotFoundException("Alerts data is not in valid format");
        }
    }
}
