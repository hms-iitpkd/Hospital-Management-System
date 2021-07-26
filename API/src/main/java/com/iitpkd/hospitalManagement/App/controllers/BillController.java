package com.iitpkd.hospitalManagement.App.controllers;


import com.iitpkd.hospitalManagement.App.dto.Bill;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.dto.Utility;
import com.iitpkd.hospitalManagement.App.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public List<Bill> getAllBills(){
        if(Authorization.getAccess_level() != 3 && Authorization.getAccess_level() != 0){
            return null;
        }
        return billService.getAllBills();
    }

    @RequestMapping(path = "/{bill_id}", method = RequestMethod.GET, produces = {"application/json"})
    public Optional<Bill> getBill(@PathVariable Integer bill_id){
        if(Authorization.getAccess_level() != 3 && Authorization.getAccess_level() != 0){
            return Optional.empty();
        }
        return billService.getBill(bill_id);
    }

    // no need to input the ID
    @RequestMapping(method=RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public Integer addBill(@RequestBody Bill bill){
        if(Authorization.getAccess_level() != 3){
            return null;
        }
        return billService.addBill(bill);
    }
}
