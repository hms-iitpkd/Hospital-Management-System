package com.iitpkd.hospitalManagement.App.controllers;


import com.iitpkd.hospitalManagement.App.dto.Admitted;
import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.Laboratory;
import com.iitpkd.hospitalManagement.App.dto.Manager;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.services.LaboratoryService;
import com.iitpkd.hospitalManagement.App.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/laboratories")
public class LaboratoryController {
    @Autowired
    private LaboratoryService labService;

    @RequestMapping(method= RequestMethod.GET, produces = {"application/json"})
    public List<Laboratory> getAllLaboratories(){
        return labService.getAllLaboratory();
    }

    @RequestMapping(path="/{id}", method= RequestMethod.GET, produces={"application/json"})
    public Optional<Laboratory> getLaboratory(@PathVariable Integer id){
        return labService.getLaboratory(id);
    }

    //To be checked
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public Integer addLaboratory(@RequestBody Laboratory newLaboratory){
        if(Authorization.getAccess_level()!=0){
            return null;
        }
        return labService.postLaboratory(newLaboratory);
    }

    @RequestMapping(path = "/{id}", method=RequestMethod.PATCH,
            produces={"application/json"}, consumes={"application/json"})
    public String updateLaboratory(@PathVariable("id") Integer id, @RequestBody Laboratory laboratory) throws ParseException {
        if(Authorization.getAccess_level()!=0){
            return null;
        }
        return labService.updateLab(id, laboratory);

    }

}
