package com.iitpkd.hospitalManagement.App.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iitpkd.hospitalManagement.App.dto.IDClasses.Payment_IDs;

import javax.persistence.*;

// CHECK LATER
@Entity
public class Payment {

    @EmbeddedId
    private Payment_IDs id;

    @Column(length = 20, name="`Mode of Payment`")
    private String modeOfPayment;

    @ManyToOne
    @MapsId("Treatment_ID")
    @JoinColumn(name = "Treatment_ID", nullable = false)
    @JsonIgnore
    private Treatment treatment;

    @ManyToOne
    @JoinColumn(name = "Bill_ID", nullable = false)
    private Bill bill;

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(final String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(final Treatment treatment) {
        this.treatment = treatment;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(final Bill bill) {
        this.bill = bill;
    }

    public Payment_IDs getId() {
        return id;
    }

    public void setId(Payment_IDs id) {
        this.id = id;
    }
}
