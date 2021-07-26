package com.iitpkd.hospitalManagement.App.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Bill {

    @Id
    @Column(nullable = false, updatable = false, name="Bill_ID")
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
    private Integer billId;

    @Column(name="GST")
    private Double gst;

    @Column(name="Total_Amount")
    private Double totalAmount;

    @Column(name="Paid")
    private Double paid;

    @Column(name="Amount_Pending")
    private Double amountPending;

    @Column(name="Date")
    private Date date;



    // Ignore Payment details
    @OneToMany(mappedBy = "bill")
    @JsonIgnore
    private Set<Payment> billPayments;

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(final Integer billId) {
        this.billId = billId;
    }

    public Double getGst() {
        return gst;
    }

    public void setGst(final Double gst) {
        this.gst = gst;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(final Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPaid() {
        return paid;
    }

    public void setPaid(final Double paid) {
        this.paid = paid;
    }

    public Double getAmountPending() {
        return amountPending;
    }

    public void setAmountPending(final Double amountPending) {
        this.amountPending = amountPending;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

//    public Set<Payment> getBillPayments() {
//        return billPayments;
//    }
//
//    public void setBillPayments(final Set<Payment> billPayments) {
//        this.billPayments = billPayments;
//    }

    public Set<Payment> getBillPayments() {
        return billPayments;
    }

    public void setBillPayments(Set<Payment> billPayments) {
        this.billPayments = billPayments;
    }
}