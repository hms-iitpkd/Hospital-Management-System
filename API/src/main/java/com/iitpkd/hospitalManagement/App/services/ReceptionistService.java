package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.Receptionist;
import com.iitpkd.hospitalManagement.App.repositories.ReceptionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReceptionistService {
    @Autowired
    private ReceptionistRepository receptionistRepository;

    public List<Receptionist> getAllReceptionists(){
        return new ArrayList<>(receptionistRepository.findAll());
    }

    public Optional<Receptionist> getReceptionist(Integer id){
        return receptionistRepository.findById(id);
    }


    //to be checked
    public Integer postReceptionist(Receptionist newReceptionist) {
        Receptionist receptionist = receptionistRepository.save(newReceptionist);
        return receptionist.getReceptionistId();
    }

    public String updateReceptionist(Integer id, Receptionist patch) throws ParseException {
        Receptionist receptionist = receptionistRepository.getOne(id);
        if(patch.getShift()!= null){
            receptionist.setShift(patch.getShift());
        }
        if(patch.getExperience() != null) {
            receptionist.setExperience(patch.getExperience());
        }
        receptionistRepository.save(receptionist);
        return "Success";
    }
}
