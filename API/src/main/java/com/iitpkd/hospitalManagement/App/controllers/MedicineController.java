package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.Medicine;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/medicines")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @RequestMapping(method= RequestMethod.GET, produces={"application/json"})
    public List<Medicine> getAllMeds(){
        return medicineService.getAllMedicine();
    }

    @RequestMapping(path = "/{id}", method= RequestMethod.GET, produces={"application/json"})
    public Optional<Medicine> getMed(@PathVariable Integer id){
        return medicineService.getMedicine(id);
    }

    //To be checked
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public Integer addMedicine(@RequestBody Medicine newMedicine){
        if(Authorization.getAccess_level()==2 || Authorization.getAccess_level()==3){
            return null;
        }
        return medicineService.postMedicine(newMedicine);
    }

    @RequestMapping(path = "/{id}", method=RequestMethod.PATCH,
            produces={"application/json"}, consumes={"application/json"})
    public String updateMedicine(@PathVariable("id") Integer id, @RequestBody Medicine medicine) throws ParseException {
        if(Authorization.getAccess_level()==2 || Authorization.getAccess_level()==3){
            return null;
        }
        return medicineService.updateMedicine(id, medicine);

    }
}
