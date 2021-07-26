package com.iitpkd.hospitalManagement.App.services;


import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.IDClasses.Visiting_IDs;
import com.iitpkd.hospitalManagement.App.dto.Visiting;
import com.iitpkd.hospitalManagement.App.dto.Visitor;
import com.iitpkd.hospitalManagement.App.repositories.AdmittedRepository;
import com.iitpkd.hospitalManagement.App.repositories.VisitingRepository;
import com.iitpkd.hospitalManagement.App.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;

    @Autowired
    private AdmittedRepository admittedRepository;

    @Autowired
    private VisitingRepository visitingRepository;

    public List<Visitor> getAllVisitors(){
        return new ArrayList<>(visitorRepository.findAll());
    }

    public Optional<Visitor> getVisitor(Integer id){
        return visitorRepository.findById(id);
    }

    // to be checked
    public Integer postVisitor(Visitor newVisitor, Integer admissionId,
                               String sessionTimings, Date date) {

        Visitor visitor = visitorRepository.save(newVisitor);
        Visiting visiting = new Visiting();

        Visiting_IDs visiting_iDs = new Visiting_IDs();
        visiting_iDs.setVisitor_ID(newVisitor.getVisitorId());
        visiting_iDs.setDate_of_Visit(Objects.requireNonNullElseGet(date, Date::new));
        visiting_iDs.setAdmission_ID(admissionId);
        visiting_iDs.setSession_Timings(sessionTimings);

        visiting.setId(visiting_iDs);
        visiting.setAdmission(admittedRepository.getOne(admissionId));
        visiting.setVisitor(visitor);

        Set<Visiting> visitingAdded = new HashSet(Collections.EMPTY_SET);
        visitingAdded.add(visitingRepository.save(visiting));

        visitor.setVisitorVisitings(visitingAdded);

        return visitor.getVisitorId();
    }

    public String updateVisitor(Integer id, Visitor patch) throws ParseException {
        Visitor visitor = visitorRepository.getOne(id);
        if(patch.getContactNumber() != null){
            visitor.setContactNumber(patch.getContactNumber());
        }
        if(patch.getRelation() != null){
            visitor.setRelation(patch.getRelation());
        }
        if(patch.getName() !=null){
            visitor.setName(patch.getName());
        }
        visitorRepository.save(visitor);
        return "Success";
    }
}
