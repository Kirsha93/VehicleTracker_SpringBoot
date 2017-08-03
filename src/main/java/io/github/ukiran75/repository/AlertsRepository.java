package io.github.ukiran75.repository;

import io.github.ukiran75.entity.Alert;
import io.github.ukiran75.entity.VehicleAlerts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Iterator;
import java.util.List;


public interface AlertsRepository extends Repository<Alert,String > {

    Alert save(Alert alert);
    //Iterator<VehicleAlerts> findAll();
    List<Alert> findAllByVin(String vin);

    @Query("select vin,count(vin) from Alert where alertType='HIGH' group by vin")
    List<Object> finAlerts();
}
