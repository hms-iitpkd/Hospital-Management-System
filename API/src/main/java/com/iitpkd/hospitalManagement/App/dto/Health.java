package com.iitpkd.hospitalManagement.App.dto;

public class Health {
    private final String status;

    public Health(final String status){
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
