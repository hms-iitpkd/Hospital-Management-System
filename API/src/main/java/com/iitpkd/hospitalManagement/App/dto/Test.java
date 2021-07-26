package com.iitpkd.hospitalManagement.App.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iitpkd.hospitalManagement.App.dto.IDClasses.Test_IDs;

import javax.persistence.*;
import java.util.Date;

// HANDLE LATER
@Entity
public class Test {

    @EmbeddedId
    private Test_IDs id;

    @Column(name="Date")
    private Date date;

    @Column(name="Price")
    private Integer price;

    @ManyToOne
    @MapsId("Treatment_ID")
    @JoinColumn(name = "Treatment_ID")
    @JsonIgnore
    private Treatment treatment;

    @ManyToOne
    @MapsId("Laboratory_ID")
    @JoinColumn(name = "Laboratory_ID")
    private Laboratory laboratory;


    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(final Integer price) {
        this.price = price;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(final Treatment treatment) {
        this.treatment = treatment;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public Test_IDs getId() {
        return id;
    }

    public void setId(Test_IDs id) {
        this.id = id;
    }

    public void setLaboratory(final Laboratory laboratory) {
        this.laboratory = laboratory;
    }

}
