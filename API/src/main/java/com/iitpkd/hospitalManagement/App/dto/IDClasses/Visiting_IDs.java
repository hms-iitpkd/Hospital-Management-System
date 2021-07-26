package com.iitpkd.hospitalManagement.App.dto.IDClasses;

import java.io.Serializable;
import java.util.Date;

public class Visiting_IDs implements Serializable {
    private String Session_Timings;
    private Date Date_of_Visit;
    private Integer Admission_ID;
    private Integer Visitor_ID;

    public Integer getAdmission_ID() {
        return Admission_ID;
    }

    public void setAdmission_ID(Integer admission_ID) {
        this.Admission_ID = admission_ID;
    }

    public Integer getVisitor_ID() {
        return Visitor_ID;
    }

    public void setVisitor_ID(Integer visitor_ID) {
        this.Visitor_ID = visitor_ID;
    }

    public String getSession_Timings() {
        return Session_Timings;
    }

    public void setSession_Timings(String session_Timings) {
        this.Session_Timings = session_Timings;
    }

    public Date getDate_of_Visit() {
        return Date_of_Visit;
    }

    public void setDate_of_Visit(Date date_of_Visit) {
        this.Date_of_Visit = date_of_Visit;
    }
}
