package com.iitpkd.hospitalManagement.App.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
public class Doctor {
    @Id
    @Column(name="Doctor_ID",nullable = false, updatable = false)
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
    private Integer doctorId;

    @Column(name="Name",nullable = false, length = 100)
    private String name;

    @Column(name="Department",length = 100)
    private String department;

    @Column(name="Experience")
    private Integer experience;

    @Column(name="Specialization",length = 100)
    private String specialization;

    @Column(name="Patients_treated")
    private Integer patientsTreated;

    @Column(name="Shift")
    private Date shift;

    @Column(name="Room_no")
    private Integer roomNo;

    @Column(name="`Consultancy Fees`")
    private Integer consultancyFees;

    @ManyToMany
    @JoinTable(
            name = "D_Job",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> dJobEmployees;

    // Ignore appointment details
    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> doctorAppointments;


    // Ignore Treatment Details
    @ManyToMany(mappedBy = "treatsDoctors")
    @JsonIgnore
    private Set<Treatment> treatsTreatments;

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(final Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(final String department) {
        this.department = department;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(final Integer experience) {
        this.experience = experience;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(final String specialization) {
        this.specialization = specialization;
    }

    public Integer getPatientsTreated() {
        return patientsTreated;
    }

    public void setPatientsTreated(final Integer patientsTreated) {
        this.patientsTreated = patientsTreated;
    }

    public Date getShift() {
        return shift;
    }

    public void setShift(final Date shift) {
        this.shift = shift;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(final Integer roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getConsultancyFees() {
        return consultancyFees;
    }

    public void setConsultancyFees(final Integer consultancyFees) {
        this.consultancyFees = consultancyFees;
    }

    public Set<Employee> getDJobEmployees() {
        return dJobEmployees;
    }

    public void setDJobEmployees(final Set<Employee> dJobEmployees) {
        this.dJobEmployees = dJobEmployees;
    }

    public Set<Appointment> getDoctorAppointments() {
        return doctorAppointments;
    }

    public void setDoctorAppointments(final Set<Appointment> doctorAppointments) {
        this.doctorAppointments = doctorAppointments;
    }

    public Set<Treatment> getTreatsTreatments() {
        return treatsTreatments;
    }

    public void setTreatsTreatments(final Set<Treatment> treatsTreatments) {
        this.treatsTreatments = treatsTreatments;
    }

}

