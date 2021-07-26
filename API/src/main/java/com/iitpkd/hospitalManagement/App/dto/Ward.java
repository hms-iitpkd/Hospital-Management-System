package com.iitpkd.hospitalManagement.App.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ward {

    @Id
    @Column(nullable = false, updatable = false, name="Room_Number")
//    @SequenceGenerator(
//            name = "primary_sequence",
//            sequenceName = "primary_sequence",
//            allocationSize = 1,
//            initialValue = 10000
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "primary_sequence"
//    )@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer roomNumber;

    @Column(name="Occupancy")
    private Integer occupancy;

    @Column(name="Beds_Available")
    private Integer bedsAvailable;

    @ManyToMany(mappedBy = "admRoomWards")
    private Set<Admitted> admRoomAdmitteds;

    @OneToMany(mappedBy = "roomNumber")
    @JsonIgnore
    private Set<WardDuty> roomNumberWardDutys;

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(final Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(final Integer occupancy) {
        this.occupancy = occupancy;
    }

    public Integer getBedsAvailable() {
        return bedsAvailable;
    }

    public void setBedsAvailable(final Integer bedsAvailable) {
        this.bedsAvailable = bedsAvailable;
    }

    public Set<Admitted> getAdmRoomAdmitteds() {
        return admRoomAdmitteds;
    }

    public void setAdmRoomAdmitteds(final Set<Admitted> admRoomAdmitteds) {
        this.admRoomAdmitteds = admRoomAdmitteds;
    }

    public Set<WardDuty> getRoomNumberWardDutys() {
        return roomNumberWardDutys;
    }

    public void setRoomNumberWardDutys(final Set<WardDuty> roomNumberWardDutys) {
        this.roomNumberWardDutys = roomNumberWardDutys;
    }

}
