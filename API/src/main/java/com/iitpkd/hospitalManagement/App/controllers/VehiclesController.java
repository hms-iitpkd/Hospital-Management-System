package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.dto.Nurse;
import com.iitpkd.hospitalManagement.App.dto.Vehicle;
import com.iitpkd.hospitalManagement.App.services.NurseService;
import com.iitpkd.hospitalManagement.App.services.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/vehicles")
public class VehiclesController {
    @Autowired
    private VehiclesService vehicleService;

    @RequestMapping(method= RequestMethod.GET, produces = {"application/json"})
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

    @RequestMapping(path = "/{id}", method=RequestMethod.PATCH,
            produces={"application/json"}, consumes={"application/json"})
    public String updateVehicle(@PathVariable("id") String id, @RequestBody Vehicle vehicle) throws ParseException {
        if(Authorization.getAccess_level() != 0){
            return null;
        }
        return vehicleService.updateVehicle(id, vehicle);

    }
}
