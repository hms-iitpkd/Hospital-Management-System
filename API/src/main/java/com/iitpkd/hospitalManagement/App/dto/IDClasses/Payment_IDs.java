package com.iitpkd.hospitalManagement.App.dto.IDClasses;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Payment_IDs implements Serializable {
    private Integer Treatment_ID;

    public Integer getTreatment_ID() {
        return Treatment_ID;
    }

    public void setTreatment_ID(Integer treatment_ID) {
        Treatment_ID = treatment_ID;
    }


}
