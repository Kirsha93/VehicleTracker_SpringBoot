package io.github.ukiran75.repository;

import io.github.ukiran75.entity.Vehicle;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface VehiclesRepository  extends Repository<Vehicle,String>{

    Vehicle findByVin(String vin);

    Vehicle save(Vehicle vehicle);

    Iterable<Vehicle> findAll();

}
