package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.Admitted;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.JsonPatch;
import com.iitpkd.hospitalManagement.App.services.AdmittedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/admitted")
public class AdmittedController {

    @Autowired
    private AdmittedService admittedService;

    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public List<Admitted> getAdmittedPatients(@RequestParam(required = false) boolean current){
        if (Authorization.getAccess_level() > 3){
            return null;
        }
        if (current){
            return admittedService.getCurrentAdmitted();
        }
        else {
            return admittedService.getAllAdmitted();
        }
    }

    @RequestMapping(path="/{id}", method=RequestMethod.GET, produces = {"application/json"})
    public Optional<Admitted> getAdmitted(@PathVariable("id") Integer id){
        if (Authorization.getAccess_level() > 3){
            return Optional.empty();
        }
        return admittedService.getAdmitted(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"})
    public Integer addAdmitted( @RequestParam("patient_id") Integer patientId,
                               @RequestParam("room_number") Integer roomNumber){
        if (Authorization.getAccess_level() != 3){
            return null;
        }
        return admittedService.postAdmitted(patientId, roomNumber);
    }

    @RequestMapping(path = "/{id}", method=RequestMethod.PATCH,
            produces={"application/json"}, consumes={"application/json"})
    public String updateAdmitted(@PathVariable("id") Integer id, @RequestBody Admitted admitted) throws ParseException {
        if (Authorization.getAccess_level() != 3){
            return null;
        }
        return admittedService.updateAdmitted(id, admitted);
    }
}
