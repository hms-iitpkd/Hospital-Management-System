package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.dto.Nurse;
import com.iitpkd.hospitalManagement.App.services.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/nurses")
public class NurseController {
    @Autowired
    private NurseService nurseService;

    @RequestMapping(method= RequestMethod.GET, produces = {"application/json"})
    public List<Nurse> getAllNurse(){
        if(Authorization.getAccess_level() > 2){
            return null;
        }
        return nurseService.getAllNurses();
    }

    @RequestMapping(path="/{id}", method= RequestMethod.GET, produces={"application/json"})
    public Nurse getNurse(@PathVariable Integer id){
        if(Authorization.getAccess_level() > 2){
            return null;
        }
        return nurseService.getNurse(id);
    }

    // To be checked
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public Integer addNurse(@RequestBody Nurse newNurse){
        if(Authorization.getAccess_level() != 0){
            return null;
        }
        return nurseService.postNurse(newNurse);
    }

    @RequestMapping(path = "/{id}", method=RequestMethod.PATCH,
            produces={"application/json"}, consumes={"application/json"})
    public String updateNurse(@PathVariable("id") Integer id, @RequestBody Nurse nurse) throws ParseException {
        if(Authorization.getAccess_level() != 0){
            return null;
        }
        return nurseService.updateNurse(id, nurse);

    }
}
