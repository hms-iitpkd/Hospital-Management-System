package com.iitpkd.hospitalManagement.App.controllers;


import com.iitpkd.hospitalManagement.App.dto.Admitted;
import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(method= RequestMethod.GET, produces={"application/json"})
    public List<Doctor> getAllDoctors(){
        if(Authorization.getAccess_level()!=0
                && Authorization.getAccess_level()!=1
                && Authorization.getAccess_level()!=3){
            return null;
        }
        return doctorService.getAllDoctors();
    }

    @RequestMapping(path="/{id}", method= RequestMethod.GET, produces={"application/json"})
    public Optional<Doctor> getDoctor(@PathVariable Integer id){
        if(Authorization.getAccess_level()!=0
                && Authorization.getAccess_level()!=1
                && Authorization.getAccess_level()!=3){
            return Optional.empty();
        }
        return doctorService.getDoctor(id);
    }

    // To be checked
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public Integer addDoctor(@RequestBody Doctor newDoctor){
        if(Authorization.getAccess_level()!=0){
            return null;
        }
        return doctorService.postDoctor(newDoctor);
    }

    @RequestMapping(path = "/{id}", method=RequestMethod.PATCH,
            produces={"application/json"}, consumes={"application/json"})
    public String updateDoctor(@PathVariable("id") Integer id, @RequestBody Doctor doctor) throws ParseException {
        if(Authorization.getAccess_level() > 1){
            return null;
        }
        return doctorService.updateDoctor(id, doctor);

    }


}
