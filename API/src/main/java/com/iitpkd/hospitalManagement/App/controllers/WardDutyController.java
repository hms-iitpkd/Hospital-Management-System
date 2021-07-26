package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.services.WardDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(path = "/wardDuty")
public class WardDutyController {
    @Autowired
    private WardDutyService wardDutyService;

    @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public String addWardDuty(@RequestParam("room_number") Integer roomNumber,
                              @RequestParam("nurse_id") Integer nurseId,
                              @RequestParam("shift") String shift,
                              @RequestParam(name = "date", required = false) Date date) {
        if (Authorization.getAccess_level() > 1) {
            return null;
        }

        return wardDutyService.addWardDuty(roomNumber, nurseId, shift, date);
    }
}
