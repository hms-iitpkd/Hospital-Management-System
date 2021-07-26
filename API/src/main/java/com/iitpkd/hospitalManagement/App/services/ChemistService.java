package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.Admitted;
import com.iitpkd.hospitalManagement.App.dto.Chemist;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.JsonPatch;
import com.iitpkd.hospitalManagement.App.repositories.ChemistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ChemistService {
    @Autowired
    private ChemistRepository chemistRepository;

    public List<Chemist> getAllChemists(){
        return new ArrayList<>(chemistRepository.findAll());
    }

    public Optional<Chemist> getChemist(Integer id){
        return chemistRepository.findById(id);
    }

    // To be checked
    public Integer postChemist(Chemist newChemist) {
        Chemist chemist = chemistRepository.save(newChemist);
        return chemist.getChemistId();
    }

    public String updateChemist(Integer id, Chemist patch) throws ParseException {
        Chemist chemist = chemistRepository.getOne(id);
        if(patch.getChJobEmployees() != null){
            chemist.setChJobEmployees(patch.getChJobEmployees());
        }
        if(patch.getShift()!=null){
            chemist.setShift(patch.getShift());
        }
        chemistRepository.save(chemist);
        return "Success";
    }
}
