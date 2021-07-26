package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.dto.Ward;
import com.iitpkd.hospitalManagement.App.services.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/wards")
public class WardController {

    @Autowired
    private WardService wardService;

    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public List<Ward> getAllWards(){
        if(Authorization.getAccess_level() > 3){
            return null;
        }
        return wardService.getAllWards();
    }

    @RequestMapping(path = "/{room_no}", method = RequestMethod.GET, produces = {"application/json"})
    public Optional<Ward> getWard(@PathVariable Integer room_no) {
        if(Authorization.getAccess_level() > 3){
            return Optional.empty();
        }
        return wardService.getWard(room_no);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public Integer addWard(@RequestBody Ward ward){
        if(Authorization.getAccess_level() != 0){
            return null;
        }
        return wardService.addWard(ward);
    }

    @RequestMapping(path = "/{id}", method=RequestMethod.PATCH,
            produces={"application/json"}, consumes={"application/json"})
    public String updateWard(@PathVariable("id") Integer id, @RequestBody Ward ward) throws ParseException {
        if(Authorization.getAccess_level() != 0 && Authorization.getAccess_level() != 3){
            return null;
        }
        return wardService.updateWard(id, ward);

    }

    @RequestMapping(path = "/empty", method = RequestMethod.GET, produces = {"application/json"})
    public Integer getEmptyWard(){
        if(Authorization.getAccess_level() != 0 && Authorization.getAccess_level() != 3){
            return null;
        }
        return wardService.getEmptyWard();
    }
}

