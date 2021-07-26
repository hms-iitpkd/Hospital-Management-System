package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.Manager;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping(method= RequestMethod.GET, produces = {"application/json"})
    public List<Manager> getAllManagers(){
        if(Authorization.getAccess_level()!=0){
            return null;
        }
        return managerService.getAllManagers();
    }

    @RequestMapping(path="/{id}", method= RequestMethod.GET, produces={"application/json"})
    public Optional<Manager> getManager(@PathVariable Integer id){
        if(Authorization.getAccess_level()!=0){
            return Optional.empty();
        }
        return managerService.getManager(id);
    }

    // To be checked
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public Integer addManager(@RequestBody Manager newManager){
        if(Authorization.getAccess_level()!=0){
            return null;
        }
        return managerService.postManager(newManager);
    }

}
