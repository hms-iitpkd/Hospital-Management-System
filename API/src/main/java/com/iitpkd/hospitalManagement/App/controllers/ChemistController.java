package com.iitpkd.hospitalManagement.App.controllers;


import com.iitpkd.hospitalManagement.App.dto.Admitted;
import com.iitpkd.hospitalManagement.App.dto.Chemist;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.JsonPatch;
import com.iitpkd.hospitalManagement.App.services.ChemistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/chemist")
public class ChemistController {
    @Autowired
    private ChemistService chemistService;

    @RequestMapping(method= RequestMethod.GET, produces = {"application/json"})
    public List<Chemist> getAllChemists(){
        if(Authorization.getAccess_level() > 1){
            return null;
        }
        return chemistService.getAllChemists();
    }

    @RequestMapping(path="/{id}", method= RequestMethod.GET, produces={"application/json"})
    public Optional<Chemist> getReceptionist(@PathVariable Integer id){
        if(Authorization.getAccess_level() > 1){
            return Optional.empty();
        }
        return chemistService.getChemist(id);
    }

    // To be checked
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public Integer addChemist(@RequestBody Chemist newChemist){
        if(Authorization.getAccess_level() > 0){
            return null;
        }
        return chemistService.postChemist(newChemist);
    }

    @RequestMapping(path = "/{id}", method=RequestMethod.PATCH,
            produces={"application/json"}, consumes={"application/json"})
    public String updateChemist(@PathVariable("id") Integer id, @RequestBody Chemist chemist) throws ParseException {
        if(Authorization.getAccess_level() > 0 && Authorization.getAccess_level() != 4){
            return null;
        }
        return chemistService.updateChemist(id, chemist);
    }
}
