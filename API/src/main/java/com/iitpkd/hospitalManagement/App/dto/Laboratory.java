package com.iitpkd.hospitalManagement.App.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Laboratory {

    @Id
    @Column(nullable = false, updatable = false, name="Laboratory_ID")
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
    private Integer laboratoryId;

    @Column(columnDefinition = "text", name="Purpose")
    private String purpose;

    @Column(columnDefinition = "text", name="Sensitivity")
    private String sensitivity;

    @Column(name="Room_no")
    private Integer roomNo;

    // Don't include Tests Data
    @OneToMany(mappedBy = "laboratory")
    @JsonIgnore
    private Set<Test> laboratoryTests;

    public Integer getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(final Integer laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(final String purpose) {
        this.purpose = purpose;
    }

    public String getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(final String sensitivity) {
        this.sensitivity = sensitivity;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(final Integer roomNo) {
        this.roomNo = roomNo;
    }

    public Set<Test> getLaboratoryTests() {
        return laboratoryTests;
    }

    public void setLaboratoryTests(final Set<Test> laboratoryTests) {
        this.laboratoryTests = laboratoryTests;
    }

}
