package com.iitpkd.hospitalManagement.App.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Login {

    @Id
    @Column(name="Email_ID",nullable = false, updatable = false, length = 100)
    private String emailId;

    @Column(name="Name",nullable = false, length = 36)
    private String name;

    @Column(name="Contact_Number")
    private Integer contactNumber;

    @Column(name="Password",nullable = false, length = 100)
    private String password;

    @Column(name="Account_Type",length = 10)
    private String accountType;

    @Column(name="Locality",length = 20)
    private String locality;

    @Column(name="Access_Level",nullable = false)
    private Integer accessLevel;

    @Column(name="Last_Login",nullable = false)
    private Date lastLogin;

//    @ManyToMany
//    @JoinTable(
//            name = "Employee_login",
//            joinColumns = @JoinColumn(name = "email_id"),
//            inverseJoinColumns = @JoinColumn(name = "employee_id")
//    )
//    @JsonIgnore
//    private Set<Employee> employeeLoginEmployees;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(final Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(final String locality) {
        this.locality = locality;
    }

    public Integer getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(final Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(final Date lastLogin) {
        this.lastLogin = lastLogin;
    }

//    public Set<Employee> getEmployeeLoginEmployees() {
//        return employeeLoginEmployees;
//    }
//
//    public void setEmployeeLoginEmployees(final Set<Employee> employeeLoginEmployees) {
//        this.employeeLoginEmployees = employeeLoginEmployees;
//    }

}
