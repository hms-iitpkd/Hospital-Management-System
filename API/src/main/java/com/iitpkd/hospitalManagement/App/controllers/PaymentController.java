package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.dto.Payment;
import com.iitpkd.hospitalManagement.App.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(path="/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @RequestMapping(method = RequestMethod.POST, consumes={"application/json"}, produces={"application/json"})
    public String addPayment(@RequestParam("treatment_id") Integer treatmentId,
                             @RequestParam("bill_id") Integer bilId,
                             @RequestParam("mode") String modeOfPayment){
        if(Authorization.getAccess_level() != 3){
            return null;
        }
        return paymentService.addPayment(treatmentId, bilId, modeOfPayment);
    }

}
