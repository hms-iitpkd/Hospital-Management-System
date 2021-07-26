package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.dto.Treatment;
import com.iitpkd.hospitalManagement.App.dto.TreatmentInput;
import com.iitpkd.hospitalManagement.App.services.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(path="/treatment")
public class TreatmentController {
    @Autowired
    private TreatmentService treatmentService;

    @RequestMapping(method= RequestMethod.POST, consumes={"application/json"}, produces = {"application/json"})
    public Integer addTreatment(@RequestBody TreatmentInput treatmentInput){
        if(Authorization.getAccess_level() != 1){
            return null;
        }
        return treatmentService.addTreatment(treatmentInput);
    }

    @RequestMapping(path = "/{id}", method=RequestMethod.PATCH,
            produces={"application/json"}, consumes={"application/json"})
    public String updateTreatment(@PathVariable("id") Integer id, @RequestBody Treatment treatment) throws ParseException {
        if(Authorization.getAccess_level() != 1){
            return null;
        }
        return treatmentService.updateTreatment(id, treatment);

    }
}
