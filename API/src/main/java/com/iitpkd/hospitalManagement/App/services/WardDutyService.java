package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.IDClasses.Ward_Duty_IDs;
import com.iitpkd.hospitalManagement.App.dto.WardDuty;
import com.iitpkd.hospitalManagement.App.repositories.NurseRepository;
import com.iitpkd.hospitalManagement.App.repositories.WardDutyRepository;
import com.iitpkd.hospitalManagement.App.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WardDutyService {
    @Autowired
    private WardDutyRepository wardDutyRepository;

    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private WardRepository wardRepository;

    public String addWardDuty(Integer roomNumber, Integer nurseId,
                              String shift, Date date){

        Ward_Duty_IDs ward_duty_iDs = new Ward_Duty_IDs();
        if (date == null){
            ward_duty_iDs.setDate(new Date());
        }
        else{
            ward_duty_iDs.setDate(date);
        }
        ward_duty_iDs.setNurse_ID(nurseId);
        ward_duty_iDs.setRoom_Number(roomNumber);
        ward_duty_iDs.setShift(shift);

        WardDuty wardDuty = new WardDuty();
        wardDuty.setId(ward_duty_iDs);
        if (nurseRepository.findById(nurseId).isPresent()) {
            wardDuty.setNurse(nurseRepository.findById(nurseId).get());
        }
        else{
            return "No Nurse Found.";
        }
        if(wardRepository.findById(roomNumber).isPresent()){
            wardDuty.setRoomNumber(wardRepository.findById(roomNumber).get());
        }
        else{
            return "No Ward Found";
        }

        wardDutyRepository.save(wardDuty);
        return "Success";
    }
}
