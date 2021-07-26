package com.iitpkd.hospitalManagement.App.dto;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Chemist {

    @Id
    @Column(name="Chemist_ID",nullable = false, updatable = false)
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
    private Integer chemistId;

    @Column(name="Name", nullable = false, length = 36)
    private String name;

    @Column(name="Contact_Number",length = 12)
    private String contactNumber;

    @Column(name="Shift")
    private Date shift;

    @ManyToMany
    @JoinTable(
            name = "Ch_Job",
            joinColumns = @JoinColumn(name = "chemist_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> chJobEmployees;

    public Integer getChemistId() {
        return chemistId;
    }

    public void setChemistId(final Integer chemistId) {
        this.chemistId = chemistId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(final String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getShift() {
        return shift;
    }

    public void setShift(final Date shift) {
        this.shift = shift;
    }

    public Set<Employee> getChJobEmployees() {
        return chJobEmployees;
    }

    public void setChJobEmployees(final Set<Employee> chJobEmployees) {
        this.chJobEmployees = chJobEmployees;
    }

}