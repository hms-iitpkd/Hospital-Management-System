package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.dto.Receptionist;
import com.iitpkd.hospitalManagement.App.services.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/receptionists")
public class ReceptionistController {
    @Autowired
    private ReceptionistService receptionistService;

    @RequestMapping(method= RequestMethod.GET, produces = {"application/json"})
    public List<Receptionist> getAllReceptionists(){

        return receptionistService.getAllReceptionists();
    }

    @RequestMapping(path="/{id}", method= RequestMethod.GET, produces={"application/json"})
    public Optional<Receptionist> getReceptionist(@PathVariable Integer id){
        return receptionistService.getReceptionist(id);
    }

    //to be checked
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public Integer addReceptionist(@RequestBody Receptionist newReceptionist){
        if(Authorization.getAccess_level() != 0){
            return null;
        }
        return receptionistService.postReceptionist(newReceptionist);
    }

    @RequestMapping(path = "/{id}", method=RequestMethod.PATCH,
            produces={"application/json"}, consumes={"application/json"})
    public String updateReceptionist(@PathVariable("id") Integer id, @RequestBody Receptionist receptionist) throws ParseException {
        if(Authorization.getAccess_level() != 0 && Authorization.getAccess_level() != 3){
            return null;
        }
        return receptionistService.updateReceptionist(id, receptionist);

    }
}
