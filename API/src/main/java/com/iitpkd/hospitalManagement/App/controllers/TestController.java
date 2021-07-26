package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/tests")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping(method= RequestMethod.POST, consumes={"application/json"}, produces={"application/json"})
    public String addTest(@RequestParam("treatment_id") Integer treatmentId,
                          @RequestParam("lab_id") Integer labId,
                          @RequestParam(value = "date", required = false) Date date,
                          @RequestParam("price") Integer price){
        if(Authorization.getAccess_level() != 1){
            return null;
        }
        return testService.addTest(treatmentId, labId, date, price);
    }

}
