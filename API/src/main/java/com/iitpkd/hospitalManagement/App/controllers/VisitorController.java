package com.iitpkd.hospitalManagement.App.controllers;


import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.dto.Visitor;
import com.iitpkd.hospitalManagement.App.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/visitors")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public List<Visitor> getAllVisitors(){
        if(Authorization.getAccess_level() != 0 && Authorization.getAccess_level() != 3){
            return null;
        }
        return visitorService.getAllVisitors();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Optional<Visitor> getVisitor(@PathVariable Integer id){
        if(Authorization.getAccess_level() != 0 && Authorization.getAccess_level() != 3) {
            return Optional.empty();
        }
        return visitorService.getVisitor(id);
    }

    // To be checked
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public Integer addVisitor(@RequestBody Visitor newVisitor,
                              @RequestParam(name = "admission_id") Integer admissionId,
                              @RequestParam(name = "session_timings") String sessionTimings,
                              @RequestParam(name = "date", required = false) Date date){
        if(Authorization.getAccess_level() != 3){
            return null;
        }
        return visitorService.postVisitor(newVisitor, admissionId, sessionTimings, date);
    }

    @RequestMapping(path = "/{id}", method=RequestMethod.PATCH,
            produces={"application/json"}, consumes={"application/json"})
    public String updateVisitor(@PathVariable("id") Integer id, @RequestBody Visitor visitor) throws ParseException {
        if(Authorization.getAccess_level() != 3){
            return null;
        }
        return visitorService.updateVisitor(id, visitor);

    }

}
