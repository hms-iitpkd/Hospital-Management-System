package com.iitpkd.hospitalManagement.App.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
public class Patient {

    @Id
    @Column(nullable = false, updatable = false, name="Patient_ID")
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer patientId;

    @Column(nullable = false, length = 36, name="Name")
    private String name;

    @Column(name="Age")
    private Integer age;

    @Column(length = 10, name="Gender")
    private String gender;

    @Column(length = 10, name="Height")
    private String height;

    @Column(length = 10, name="Weight")
    private String weight;

    @Column(length = 5, name="Blood_Group")
    private String bloodGroup;

    @Column(name="Contact_Number")
    private Integer contactNumber;

    @Column(length = 100, name="Email_ID")
    private String emailId;

    @Column(length = 100, name="Address")
    private String address;

    @Column(name = "History")
    private String history;

    @Column(name = "Last_Visit_Date")
    private Date lastVisitDate;

//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//            name = "Stay",
//            joinColumns = @JoinColumn(name = "patient_id"),
//            inverseJoinColumns = @JoinColumn(name = "admission_id")
//    )
//    @JsonIgnore
//    private Set<Admitted> stayAdmitteds;

    @ManyToMany(mappedBy = "stayPatients")
    @JsonIgnore
    private Set<Admitted> stayAdmitteds;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Appointment> patientAppointments;


//    @ManyToMany
//    @JoinTable(
//            name = "Patient_Treatment",
//            joinColumns = @JoinColumn(name = "Patient_ID"),
//            inverseJoinColumns = @JoinColumn(name = "Treatment_ID")
//    )
//    private Set<Treatment> patientTreatmentTreatments;

    @ManyToMany(mappedBy = "patientTreatmentPatients")
    private Set<Treatment> patientTreatmentTreatments;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(final Integer patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(final String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(final String weight) {
        this.weight = weight;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(final String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(final Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(final String history) {
        this.history = history;
    }

    public Date getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(final Date lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public Set<Admitted> getStayAdmitteds() {
        return stayAdmitteds;
    }

    public void setStayAdmitteds(final Set<Admitted> stayAdmitteds) {
        this.stayAdmitteds = stayAdmitteds;
    }

    public Set<Appointment> getPatientAppointments() {
        return patientAppointments;
    }

    public void setPatientAppointments(final Set<Appointment> patientAppointments) {
        this.patientAppointments = patientAppointments;
    }

    public Set<Treatment> getPatientTreatmentTreatments() {
        return patientTreatmentTreatments;
    }

    public void setPatientTreatmentTreatments(final Set<Treatment> patientTreatmentTreatments) {
        this.patientTreatmentTreatments = patientTreatmentTreatments;
    }

}

