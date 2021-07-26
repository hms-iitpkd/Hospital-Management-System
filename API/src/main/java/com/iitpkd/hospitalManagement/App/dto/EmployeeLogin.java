package com.iitpkd.hospitalManagement.App.dto;

import javax.persistence.*;

@Entity
@Table(name = "employee_login")
public class EmployeeLogin {

    @Id
    @Column(name="Employee_ID", nullable = false, updatable = false)
    int employeeId;

    @Column(name = "Email_ID")
    String emailId;

    public EmployeeLogin() {
        super();
    }

    public EmployeeLogin(int employeeId, String emailId) {
        this.employeeId = employeeId;
        this.emailId = emailId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
