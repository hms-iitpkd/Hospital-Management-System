package com.iitpkd.hospitalManagement.App.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Set;

@Entity
public class Treatment {

    @Id
    @Column(nullable = false, updatable = false, name="Treatment_ID")
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
    private Integer treatmentId;

    @Column(nullable = false, name="Date")
    private Date date;

    @Column(nullable = false, name = "`Description`", columnDefinition = "text")
    private String description;

    @Column(columnDefinition = "text", name="Problem")
    private String problem;

    @OneToMany(mappedBy = "treatment")
    private Set<Payment> treatmentPayments;

    @OneToMany(mappedBy = "treatment")
    private Set<Test> treatmentTests;

    @ManyToMany
    @JoinTable(
            name = "Includes",
            joinColumns = @JoinColumn(name = "Treatment_ID"),
            inverseJoinColumns = @JoinColumn(name = "Medicine_ID")
    )
    private Set<Medicine> includesMedicines;

    // We want doctor corresponding to each Treatment
    @ManyToMany
    @JoinTable(
            name = "Treats",
            joinColumns = @JoinColumn(name = "Treatment_ID"),
            inverseJoinColumns = @JoinColumn(name = "Doctor_ID")
    )
    @JsonIgnore
    private Set<Doctor> treatsDoctors;

    // We don't want Patient corresponding to each Treatment -- have reverse relationship
//    @ManyToMany(mappedBy = "patientTreatmentTreatments")
//    @JsonIgnore
//    private Set<Patient> patientTreatmentPatients;


    @ManyToMany
    @JoinTable(
            name = "Patient_Treatment",
            joinColumns = @JoinColumn(name = "Treatment_ID"),
            inverseJoinColumns = @JoinColumn(name = "Patient_ID")
    )
    @JsonIgnore
    private Set<Patient> patientTreatmentPatients;

    public Integer getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(final Integer treatmentId) {
        this.treatmentId = treatmentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(final String problem) {
        this.problem = problem;
    }

    public Set<Payment> getTreatmentPayments() {
        return treatmentPayments;
    }

    public void setTreatmentPayments(final Set<Payment> treatmentPayments) {
        this.treatmentPayments = treatmentPayments;
    }

    public Set<Test> getTreatmentTests() {
        return treatmentTests;
    }

    public void setTreatmentTests(final Set<Test> treatmentTests) {
        this.treatmentTests = treatmentTests;
    }

    public Set<Medicine> getIncludesMedicines() {
        return includesMedicines;
    }

    public void setIncludesMedicines(final Set<Medicine> includesMedicines) {
        this.includesMedicines = includesMedicines;
    }

    public Set<Doctor> getTreatsDoctors() {
        return treatsDoctors;
    }

    public void setTreatsDoctors(final Set<Doctor> treatsDoctors) {
        this.treatsDoctors = treatsDoctors;
    }

    public Set<Patient> getPatientTreatmentPatients() {
        return patientTreatmentPatients;
    }

    public void setPatientTreatmentPatients(final Set<Patient> patientTreatmentPatients) {
        this.patientTreatmentPatients = patientTreatmentPatients;
    }

}
