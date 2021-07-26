package com.iitpkd.hospitalManagement.App.dto;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Nurse {

    @Id
    @Column(nullable = false, updatable = false, name="Nurse_ID")
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
    private Integer nurseId;

    @Column(nullable = false, length = 100, name="Name")
    private String name;

    @Column(name="Experience")
    private Integer experience;

    @OneToMany(mappedBy = "nurse")
    private Set<WardDuty> nurseWardDutys;

    @ManyToMany
    @JoinTable(
            name = "N_Job",
            joinColumns = @JoinColumn(name = "nurse_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> nJobEmployees;

    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(final Integer nurseId) {
        this.nurseId = nurseId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(final Integer experience) {
        this.experience = experience;
    }

    public Set<WardDuty> getNurseWardDutys() {
        return nurseWardDutys;
    }

    public void setNurseWardDutys(final Set<WardDuty> nurseWardDutys) {
        this.nurseWardDutys = nurseWardDutys;
    }

    public Set<Employee> getNJobEmployees() {
        return nJobEmployees;
    }

    public void setNJobEmployees(final Set<Employee> nJobEmployees) {
        this.nJobEmployees = nJobEmployees;
    }

}
