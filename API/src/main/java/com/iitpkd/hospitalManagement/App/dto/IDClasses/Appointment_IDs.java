package com.iitpkd.hospitalManagement.App.dto.IDClasses;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class Appointment_IDs implements Serializable {
    private Integer Patient_ID;
    private Integer Doctor_ID;
    private Date Date_Time;


    public Integer getPatient_ID() {
        return Patient_ID;
    }

    public void setPatient_ID(Integer patient_ID) {
        Patient_ID = patient_ID;
    }

    public Integer getDoctor_ID() {
        return Doctor_ID;
    }

    public void setDoctor_ID(Integer doctor_ID) {
        Doctor_ID = doctor_ID;
    }

    public Date getDate_Time() {
        return Date_Time;
    }

    public void setDate_Time(Date date_Time) {
        Date_Time = date_Time;
    }
}