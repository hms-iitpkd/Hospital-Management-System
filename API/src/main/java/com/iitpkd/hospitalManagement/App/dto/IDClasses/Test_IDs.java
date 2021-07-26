package com.iitpkd.hospitalManagement.App.dto.IDClasses;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Test_IDs implements Serializable {

    @Column(name = "Treatment_ID")
    private Integer treatmentID;
    @Column(name="Laboratory_ID")
    private Integer laboratoryId;

    public Integer getTreatmentID() {
        return treatmentID;
    }

    public void setTreatmentID(Integer treatmentID) {
        this.treatmentID = treatmentID;
    }

    public Integer getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Integer laboratoryId) {
        this.laboratoryId = laboratoryId;
    }
}
