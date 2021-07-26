package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.dto.Patient;
import com.iitpkd.hospitalManagement.App.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @RequestMapping(method = RequestMethod.GET, produces={"application/json"})
    public List<Patient> getAllPatients(){
        if(Authorization.getAccess_level() > 3){
            return null;
        }
        return patientService.getAllPatients();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces={"application/json"})
    public Optional<Patient> getAllPatients(@PathVariable Integer id){
        if(Authorization.getAccess_level() > 3){
            return Optional.empty();
        }
        return patientService.getPatient(id);
    }

    //to be checked
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public Integer addPatient(@RequestBody Patient newPatient){
        if(Authorization.getAccess_level() != 3){
            return null;
        }
        return patientService.postPatient(newPatient);
    }

    @RequestMapping(path = "/{id}", method=RequestMethod.PATCH,
            produces={"application/json"}, consumes={"application/json"})
    public String updatePatient(@PathVariable("id") Integer id, @RequestBody Patient patient) throws ParseException {
        if(Authorization.getAccess_level() != 3){
            return null;
        }
        return patientService.updatePatient(id, patient);

    }
}
