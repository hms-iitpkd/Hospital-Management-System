package com.iitpkd.hospitalManagement.App.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Admitted {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Admission_ID;

    @Column(name="Date_of_Admission")
    private Date dateOfAdmission;

    @Column(name="Date_of_disharge")
    private Date dateOfDisharge;

//    @ManyToMany(mappedBy = "stayAdmitteds")
//    private Set<Patient> stayPatients;

    @ManyToMany
    @JoinTable(
            name = "Stay",
            joinColumns = @JoinColumn(name = "Admission_ID"),
            inverseJoinColumns = @JoinColumn(name = "Patient_ID")
    )
    private Set<Patient> stayPatients;

    @ManyToMany
    @JoinTable(
            name = "Adm_Room",
            joinColumns = @JoinColumn(name = "Admission_ID"),
            inverseJoinColumns = @JoinColumn(name = "Room_Number")
    )
    @JsonIgnore
    private Set<Ward> admRoomWards;

    @OneToMany(mappedBy = "admission")
    private Set<Visiting> admissionVisitings;

    public Integer getAdmissionId() {
        return Admission_ID;
    }

    public void setAdmissionId(final Integer admissionId) {
        this.Admission_ID = admissionId;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(final Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public Date getDateOfDisharge() {
        return dateOfDisharge;
    }

    public void setDateOfDisharge(final Date dateOfDisharge) {
        this.dateOfDisharge = dateOfDisharge;
    }

    public Set<Patient> getStayPatients() {
        return stayPatients;
    }

    public void setStayPatients(final Set<Patient> stayPatients) {
        this.stayPatients = stayPatients;
    }

    public Set<Ward> getAdmRoomWards() {
        return admRoomWards;
    }

    public void setAdmRoomWards(final Set<Ward> admRoomWards) {
        this.admRoomWards = admRoomWards;
    }

    public Set<Visiting> getAdmissionVisitings() {
        return admissionVisitings;
    }

    public void setAdmissionVisitings(final Set<Visiting> admissionVisitings) {
        this.admissionVisitings = admissionVisitings;
    }

}