package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.Admitted;
import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.Laboratory;
import com.iitpkd.hospitalManagement.App.dto.Manager;
import com.iitpkd.hospitalManagement.App.repositories.LaboratoryRepository;
import com.iitpkd.hospitalManagement.App.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class LaboratoryService {
    @Autowired
    private LaboratoryRepository laboratoryRepository;

    public List<Laboratory> getAllLaboratory(){
        return new ArrayList<>(laboratoryRepository.findAll());
    }

    public Optional<Laboratory> getLaboratory(Integer id){
        return laboratoryRepository.findById(id);
    }

    // To be checked
    public Integer postLaboratory(Laboratory newLaboratory ) {
        newLaboratory.setLaboratoryTests(null);
        Laboratory laboratory = laboratoryRepository.save(newLaboratory);
        return laboratory.getLaboratoryId();
    }

    public String updateLab(Integer id, Laboratory patch) throws ParseException {
        Laboratory laboratory = laboratoryRepository.getOne(id);
        if(patch.getRoomNo() != null){
            laboratory.setRoomNo(patch.getRoomNo());
        }
        laboratoryRepository.save(laboratory);
        return "Success";
    }
}
