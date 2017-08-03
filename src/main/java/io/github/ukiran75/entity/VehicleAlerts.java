package io.github.ukiran75.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity to store the grouped(count) alerts of a vehicle
 */
@Entity()
public class VehicleAlerts {
    @Id
    String id;
    int numberOfAlerts;

    public VehicleAlerts(String id, int numberOfAlerts){
        this.id = id;
        this.numberOfAlerts = numberOfAlerts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumberOfAlerts() {
        return numberOfAlerts;
    }

    public void setNumberOfAlerts(int numberOfAlerts) {
        this.numberOfAlerts = numberOfAlerts;
    }


}
