package com.iitpkd.hospitalManagement.App.dto;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Receptionist {

    @Id
    @Column(name="Receptionist_ID",nullable = false, updatable = false)
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
    private Integer receptionistId;

    @Column(name="Name",nullable = false, length = 36)
    private String name;

    @Column(name="Experience",columnDefinition = "text")
    private String experience;

    @Column(name="Shift",length = 11)
    private String shift;

    @ManyToMany
    @JoinTable(
            name = "R_Job",
            joinColumns = @JoinColumn(name = "Employee_id"),
            inverseJoinColumns = @JoinColumn(name = "Receptionist_id")
    )
    private Set<Employee> rJobEmployees;

    public Integer getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(final Integer receptionistId) {
        this.receptionistId = receptionistId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(final String experience) {
        this.experience = experience;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(final String shift) {
        this.shift = shift;
    }

    public Set<Employee> getRJobEmployees() {
        return rJobEmployees;
    }

    public void setRJobEmployees(final Set<Employee> rJobEmployees) {
        this.rJobEmployees = rJobEmployees;
    }

}
