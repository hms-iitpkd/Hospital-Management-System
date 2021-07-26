package com.iitpkd.hospitalManagement.App.dto;

import javax.persistence.*;

import java.util.Set;

@Entity
public class Manager {

    @Id
    @Column(name="Manager_ID",nullable = false, updatable = false)
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
    private Integer managerId;

    @Column(name="Name",nullable = false, length = 36)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "M_Job",
            joinColumns = @JoinColumn(name = "manager_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> mJobEmployees;

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(final Integer managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<Employee> getMJobEmployees() {
        return mJobEmployees;
    }

    public void setMJobEmployees(final Set<Employee> mJobEmployees) {
        this.mJobEmployees = mJobEmployees;
    }

}
