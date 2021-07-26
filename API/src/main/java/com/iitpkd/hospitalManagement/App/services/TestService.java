package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.IDClasses.Test_IDs;
import com.iitpkd.hospitalManagement.App.dto.Test;
import com.iitpkd.hospitalManagement.App.repositories.LaboratoryRepository;
import com.iitpkd.hospitalManagement.App.repositories.TestRepository;
import com.iitpkd.hospitalManagement.App.repositories.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private LaboratoryRepository laboratoryRepository;

    public String addTest(Integer treatmentId, Integer labId,
                          Date date, Integer price){
        Test_IDs test_iDs = new Test_IDs();
        test_iDs.setTreatmentID(treatmentId);
        test_iDs.setLaboratoryId(labId);

        Test test = new Test();
        test.setId(test_iDs);
        test.setPrice(price);
        test.setDate(Objects.requireNonNullElseGet(date, Date::new));
        if(treatmentRepository.findById(treatmentId).isPresent()){
            test.setTreatment(treatmentRepository.findById(treatmentId).get());
        }
        else{
            return "No treatment found";
        }
        if(laboratoryRepository.findById(labId).isPresent()){
            test.setLaboratory(laboratoryRepository.findById(labId).get());
        }
        else{
            return "No laboratory found";
        }
        testRepository.save(test);
        return "Success";
    }
}
