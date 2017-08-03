package io.github.ukiran75.repository;

import io.github.ukiran75.entity.Reading;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ReadingsRepository extends Repository<Reading,String>{

    Reading save(Reading reading);

    List<Reading> findAllByVin(String vin);
}
