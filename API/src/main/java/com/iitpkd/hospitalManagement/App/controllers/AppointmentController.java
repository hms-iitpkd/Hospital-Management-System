package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.Admitted;
import com.iitpkd.hospitalManagement.App.dto.Appointment;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public List<Appointment> getAllAppointments(){
        if(Authorization.getAccess_level() != 1
                && Authorization.getAccess_level() != 3
                && Authorization.getAccess_level() != 0 ){
            return null;
        }
        return appointmentService.getAllAppointments();
    }

    @RequestMapping(path="/{date}", method = RequestMethod.GET, produces = {"application/json"})
    public Optional<Appointment> getAdmitted(@PathVariable("id") Date date){
        if(Authorization.getAccess_level() != 3
                && Authorization.getAccess_level() != 1
                && Authorization.getAccess_level() != 0 ){
            return Optional.empty();
        }
        return appointmentService.getAppointment(date);
    }

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"})
    public String addAppointment(@RequestParam(name = "date", required = false) String time,
                                 @RequestParam("patient_id") Integer patient_id,
                                 @RequestParam("doctor_id") Integer docter_id) throws ParseException {

        if(Authorization.getAccess_level() != 3){
            return null;
        }
        Date date = null;
        if (time != null) {
            date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(time);
        }
        System.out.println(patient_id + " " + docter_id + " " + time);

        return appointmentService.postAppointment(date, patient_id, docter_id);
    }

}
