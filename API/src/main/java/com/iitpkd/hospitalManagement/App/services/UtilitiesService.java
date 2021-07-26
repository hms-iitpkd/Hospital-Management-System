package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.Utility;
import com.iitpkd.hospitalManagement.App.dto.Vehicle;
import com.iitpkd.hospitalManagement.App.repositories.UtilityRepository;
import com.iitpkd.hospitalManagement.App.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UtilitiesService {
    @Autowired
    private UtilityRepository utilityRepository;

    public List<Utility> getAllUtilities(){
        return new ArrayList<>(utilityRepository.findAll());
    }

    public Integer addUtility(Utility utility){
        Utility u = utilityRepository.save(utility);
        return u.getItemId();
    }

    public String updateUtility(Integer id, Utility patch) throws ParseException {
        Utility utility = utilityRepository.getOne(id);
        if(patch.getNumber() != null){
            utility.setNumber(patch.getNumber());
        }
        if(patch.getType() != null){
            utility.setType(patch.getType());
        }
        if(patch.getName() !=null){
            utility.setName(patch.getName());
        }
        utilityRepository.save(utility);
        return "Success";
    }
}
