package com.iitpkd.hospitalManagement.App.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iitpkd.hospitalManagement.App.dto.IDClasses.Appointment_IDs;

import javax.persistence.*;
import java.util.Date;

@Entity
//@IdClass(Appointment_IDs.class)
public class Appointment {

//    @Id
//    @Column(nullable = false, updatable = false)
//    @SequenceGenerator(
//            name = "primary_sequence",
//            sequenceName = "primary_sequence",
//            allocationSize = 1,
//            initialValue = 10000
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "primary_sequence"
//    )
//    private Long id;

//    @Id
//    @Column(nullable = false, name="Date_Time")
//    private Date dateTime;

    @EmbeddedId
    Appointment_IDs id;

    @ManyToOne
    @MapsId("Patient_ID")
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;

    @ManyToOne
    @MapsId("Doctor_ID")
    @JoinColumn(name = "Doctor_ID", nullable = false)
    @JsonIgnore
    private Doctor doctor;


//    public Date getDateTime() {
//        return dateTime;
//    }
//
//    public void setDateTime(final Date dateTime) {
//        this.dateTime = dateTime;
//    }


    public Appointment_IDs getId() {
        return id;
    }

    public void setId(Appointment_IDs id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(final Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(final Doctor doctor) {
        this.doctor = doctor;
    }

}
