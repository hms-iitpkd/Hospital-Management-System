package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.Nurse;
import com.iitpkd.hospitalManagement.App.repositories.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {
    @Autowired
    private NurseRepository nurseRepository;

    public List<Nurse> getAllNurses(){
        return new ArrayList<>(nurseRepository.findAll());
    }

    public Nurse getNurse(Integer id){
        return nurseRepository.findById(id).get();
    }

    // To be checked
    public Integer postNurse(Nurse newNurse) {
        Nurse nurse = nurseRepository.save(newNurse);
        return nurse.getNurseId();
    }

    public String updateNurse(Integer id, Nurse patch) throws ParseException {
        Nurse nurse = nurseRepository.getOne(id);

        if(patch.getNurseWardDutys() != null){
            nurse.setNurseWardDutys(patch.getNurseWardDutys());
        }

        nurseRepository.save(nurse);
        return "Success";
    }
}