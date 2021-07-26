package com.iitpkd.hospitalManagement.App.dto;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Set;

@Entity
public class Visitor {

    @Id
    @Column(nullable = false, updatable = false, name="Visitor_ID")
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
    private Integer visitorId;

    @Column(nullable = false, length = 36, name="Name")
    private String name;

    @Column(length = 36, name="Contact_Number")
    private String contactNumber;

    @Column(length = 36, name="Relation")
    private String relation;

    @JsonIgnore
    @OneToMany(mappedBy = "visitor")
    private Set<Visiting> visitorVisitings;

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(final Integer visitorId) {
        this.visitorId = visitorId;
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

    public String getRelation() {
        return relation;
    }

    public void setRelation(final String relation) {
        this.relation = relation;
    }

    public Set<Visiting> getVisitorVisitings() {
        return visitorVisitings;
    }

    public void setVisitorVisitings(final Set<Visiting> visitorVisitings) {
        this.visitorVisitings = visitorVisitings;
    }

}
