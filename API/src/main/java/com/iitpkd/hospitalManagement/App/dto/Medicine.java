package com.iitpkd.hospitalManagement.App.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Medicine {

    @Id
    @Column(nullable = false, updatable = false, name="Medicine_ID")
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
    private Integer medicineId;

    @Column(length = 100, name="Name")
    private String name;

    @Column(length = 100, name="`Type`")
    private String type;

    @Column(name="Price")
    private Integer price;

    @Column(name="Stock")
    private Integer stock;

    @Column(length = 100, name="Vendor")
    private String vendor;

    @Column(name="Expiry_Date")
    private Date expiryDate;

    @ManyToMany(mappedBy = "includesMedicines")
    @JsonIgnore
    private Set<Treatment> includesTreatments;

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(final Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(final Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(final Integer stock) {
        this.stock = stock;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(final String vendor) {
        this.vendor = vendor;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(final Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Set<Treatment> getIncludesTreatments() {
        return includesTreatments;
    }

    public void setIncludesTreatments(final Set<Treatment> includesTreatments) {
        this.includesTreatments = includesTreatments;
    }

}
