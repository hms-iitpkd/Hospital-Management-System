package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.dto.Utility;
import com.iitpkd.hospitalManagement.App.services.UtilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/utilities")
public class UtilityController {
    @Autowired
    private UtilitiesService utilitiesService;

    @RequestMapping(method= RequestMethod.GET, produces = {"application/json"})
    public List<Utility> getAllUtilities(){
        return utilitiesService.getAllUtilities();
    }

    // no need to input the ID
    @RequestMapping(method=RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public Integer addUtility(@RequestBody Utility utility){
        if(Authorization.getAccess_level() != 0){
            return null;
        }
        return utilitiesService.addUtility(utility);
    }

    @RequestMapping(path = "/{id}", method=RequestMethod.PATCH,
            produces={"application/json"}, consumes={"application/json"})
    public String updateUtility(@PathVariable("id") Integer id, @RequestBody Utility utility) throws ParseException {
        if(Authorization.getAccess_level() != 0){
            return null;
        }
        return utilitiesService.updateUtility(id, utility);

    }
}
