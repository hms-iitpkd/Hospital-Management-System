package com.iitpkd.hospitalManagement.App.dto.IDClasses;

import java.io.Serializable;
import java.util.Date;

//@Embeddable
public class Ward_Duty_IDs implements Serializable {
    private String Shift;
    private Date Date;
    private Integer Room_Number;
    private Integer Nurse_ID;

    public Integer getRoom_Number() {
        return Room_Number;
    }

    public void setRoom_Number(Integer room_Number) {
        Room_Number = room_Number;
    }

    public Integer getNurse_ID() {
        return Nurse_ID;
    }

    public void setNurse_ID(Integer nurse_ID) {
        Nurse_ID = nurse_ID;
    }

    public String getShift() {
        return Shift;
    }

    public void setShift(String shift) {
        this.Shift = shift;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        this.Date = date;
    }
}
