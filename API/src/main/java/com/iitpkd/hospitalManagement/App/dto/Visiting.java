package com.iitpkd.hospitalManagement.App.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iitpkd.hospitalManagement.App.dto.IDClasses.Visiting_IDs;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Entity
//@IdClass(Visiting_IDs.class)
public class Visiting {

//    @Id
//    @Column(nullable = false, updatable = false, name = "Admission_ID")
//    private Integer admitted_ID;
//
//    @Id
//    @Column(nullable = false, updatable = false, name = "Visitor_ID")
//    private Integer visitor_ID;
//
//    @Id
//    @Column(nullable = false, updatable = false, length = 100, name = "Session_Timings")
//    private String sessionTimings;
//
//    @Id
//    @Column(name="Date_of_Visit")
//    private Date dateOfVisit;

    @EmbeddedId
    private Visiting_IDs id;

    @ManyToOne
    @MapsId("Visitor_ID")
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;


    @ManyToOne
    @MapsId("Admission_ID")
    @JsonIgnore
    @JoinColumn(name = "admission_id", nullable = false)
    private Admitted admission;

    public Visiting_IDs getId() {
        return id;
    }

    public void setId(Visiting_IDs id) {
        this.id = id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Admitted getAdmission() {
        return admission;
    }

    public void setAdmission(Admitted admission) {
        this.admission = admission;
    }

    //    public String getSessionTimings() {
//        return sessionTimings;
//    }
//
//    public void setSessionTimings(final String sessionTimings) {
//        this.sessionTimings = sessionTimings;
//    }
//
//    public Date getDateOfVisit() {
//        return dateOfVisit;
//    }
//
//    public void setDateOfVisit(final Date dateOfVisit) {
//        this.dateOfVisit = dateOfVisit;
//    }
//
//    public Visitor getVisitor() {
//        return visitor;
//    }
//
//    public void setVisitor(final Visitor visitor) {
//        this.visitor = visitor;
//    }
//
//    public Admitted getAdmission() {
//        return admission;
//    }
//
//    public void setAdmission(final Admitted admission) {
//        this.admission = admission;
//    }
//
//    public Integer getAdmitted_ID() {
//        return admitted_ID;
//    }
//
//    public void setAdmitted_ID(Integer admitted_ID) {
//        this.admitted_ID = admitted_ID;
//    }
//
//    public Integer getVisitor_ID() {
//        return visitor_ID;
//    }
//
//    public void setVisitor_ID(Integer visitor_ID) {
//        this.visitor_ID = visitor_ID;
//    }
}