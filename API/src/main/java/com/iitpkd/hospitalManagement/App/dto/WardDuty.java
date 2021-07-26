package com.iitpkd.hospitalManagement.App.dto;

import com.iitpkd.hospitalManagement.App.dto.IDClasses.Ward_Duty_IDs;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Ward_Duty")
//@IdClass(Ward_Duty_IDs.class)
public class WardDuty {

//    @Id
//    @Column(nullable = false, updatable = false, length = 20, name="Shift")
//    private String shift;
//
//    @Id
//    @Column(nullable = false, name="Date")
//    private Date date;
//
//    @Id
//    @Column(name="Room_Number")
//    private Integer Room_number;
//
//    @Id
//    @Column(name="Nurse_ID")
//    private Integer Nurse_id;

    @EmbeddedId
    Ward_Duty_IDs id;

    @ManyToOne
    @MapsId("Nurse_ID")
    @JoinColumn(name = "Nurse_ID")
    @JsonIgnore
    private Nurse nurse;

    @ManyToOne
    @MapsId("Room_Number")
    @JoinColumn(name = "Room_Number")
    @JsonIgnore
    private Ward roomNumber;


//    @Column(name = "Room_Number")
//    private int roomNumber;

//    public String getShift() {
//        return shift;
//    }
//
//    public void setShift(final String shift) {
//        this.shift = shift;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(final Date date) {
//        this.date = date;
//    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(final Nurse nurse) {
        this.nurse = nurse;
    }

//    public int getRoomNumber() {
//        return roomNumber;
//    }
//
//    public void setRoomNumber(final int roomNumber) {
//        this.roomNumber = roomNumber;
//    }

//    public Integer getRoom_number() {
//        return Room_number;
//    }
//
//    public void setRoom_number(Integer room_number) {
//        Room_number = room_number;
//    }
//
//    public Integer getNurse_id() {
//        return Nurse_id;
//    }
//
//    public void setNurse_id(Integer nurse_id) {
//        Nurse_id = nurse_id;
//    }

    public Ward_Duty_IDs getId() {
        return id;
    }

    public void setId(Ward_Duty_IDs id) {
        this.id = id;
    }

    public Ward getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Ward roomNumber) {
        this.roomNumber = roomNumber;
    }
}