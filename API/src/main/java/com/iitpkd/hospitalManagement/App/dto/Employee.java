package com.iitpkd.hospitalManagement.App.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @Column(name="Employee_ID", nullable = false, updatable = false)
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
    private Integer employeeId;

    @Column(name="Government_ID", nullable = false)
    private Integer governmentId;

    @Column(name="Name",nullable = false, length = 100)
    private String name;

    @Column(name="Date_of_Birth")
    private Date dateOfBirth;

    @Column(name="Gender")
    private String gender;

    @Column(name="Contact_Number",length = 12)
    private String contactNumber;

    @Column(name="Address",length = 100)
    private String address;

    @Column(name="Blood_Group",length = 3)
    private String bloodGroup;

    @Column(name="Email_ID",nullable = false, length = 100)
    private String emailId;

    @Column(name="Date_of_Joining")
    private Date dateOfJoining;

    @Column(name="Date_of_Termination")
    private Date dateOfTermination;

    @Column(name="Department",length = 100)
    private String department;

    @Column(name="Annual_Salary")
    private Integer annualSalary;

    public Employee() {
        super();
    }

    public Employee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    //    @ManyToMany(mappedBy = "nJobEmployees")
//    @JsonIgnore
//    private Set<Nurse> nJobNurses;



//    @ManyToMany(mappedBy = "employeeLoginEmployees")
////    @JsonIgnore
//    private Set<Login> employeeLoginLogins;

//    @ManyToMany(mappedBy = "chJobEmployees")
//    @JsonIgnore
//    private Set<Chemist> chJobChemists;
//
//    @ManyToMany(mappedBy = "dJobEmployees")
//    @JsonIgnore
//    private Set<Doctor> dJobDoctors;
//
//    @ManyToMany(mappedBy = "rJobEmployees")
//    @JsonIgnore
//    private Set<Receptionist> rJobReceptionists;
//
//    @ManyToMany(mappedBy = "mJobEmployees")
//    @JsonIgnore
//    private Set<Manager> mJobManagers;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(final Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getGovernmentId() {
        return governmentId;
    }

    public void setGovernmentId(final Integer governmentId) {
        this.governmentId = governmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(final String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(final String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(final Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Date getDateOfTermination() {
        return dateOfTermination;
    }

    public void setDateOfTermination(final Date dateOfTermination) {
        this.dateOfTermination = dateOfTermination;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(final String department) {
        this.department = department;
    }

    public Integer getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(final Integer annualSalary) {
        this.annualSalary = annualSalary;
    }

//    public Set<Nurse> getNJobNurses() {
//        return nJobNurses;
//    }
//
//    public void setNJobNurses(final Set<Nurse> nJobNurses) {
//        this.nJobNurses = nJobNurses;
//    }

//    public Set<Login> getEmployeeLoginLogins() {
//        return employeeLoginLogins;
//    }
//
//    public void setEmployeeLoginLogins(final Set<Login> employeeLoginLogins) {
//        this.employeeLoginLogins = employeeLoginLogins;
//    }

//    public Set<Chemist> getChJobChemists() {
//        return chJobChemists;
//    }
//
//    public void setChJobChemists(final Set<Chemist> chJobChemists) {
//        this.chJobChemists = chJobChemists;
//    }
//
//    public Set<Doctor> getDJobDoctors() {
//        return dJobDoctors;
//    }
//
//    public void setDJobDoctors(final Set<Doctor> dJobDoctors) {
//        this.dJobDoctors = dJobDoctors;
//    }
//
//    public Set<Receptionist> getRJobReceptionists() {
//        return rJobReceptionists;
//    }
//
//    public void setRJobReceptionists(final Set<Receptionist> rJobReceptionists) {
//        this.rJobReceptionists = rJobReceptionists;
//    }
//
//    public Set<Manager> getMJobManagers() {
//        return mJobManagers;
//    }
//
//    public void setMJobManagers(final Set<Manager> mJobManagers) {
//        this.mJobManagers = mJobManagers;
//    }

}

