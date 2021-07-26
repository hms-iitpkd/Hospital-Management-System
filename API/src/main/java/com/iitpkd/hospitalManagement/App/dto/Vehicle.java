package com.iitpkd.hospitalManagement.App.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {

    @Id
    @Column(nullable = false, updatable = false, length = 36, name="Vehicle_Number")
    private String vehicleNumber;

    @Column(nullable = false, length = 20, name="Type")
    private String type;

    @Column(name="In_Use")
    private Integer inUse;

    @Column(name = "`Description`")
    private String description;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(final String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Integer getInUse() {
        return inUse;
    }

    public void setInUse(final Integer inUse) {
        this.inUse = inUse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
