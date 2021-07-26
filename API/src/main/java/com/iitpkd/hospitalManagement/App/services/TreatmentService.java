package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.*;
import com.iitpkd.hospitalManagement.App.dto.IDClasses.Test_IDs;
import com.iitpkd.hospitalManagement.App.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class TreatmentService {
    @Autowired
    private TreatmentRepository treatmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private TestRepository testRepository;


    public Integer addTreatment(TreatmentInput treatmentInput){
        int doctor_Id = treatmentInput.getDoctorId();
        int patientId = treatmentInput.getPatientId();
        Set<Integer> medicineId = treatmentInput.getMedicineId();
        Set<Integer> testId = treatmentInput.getTestId();

        Treatment treatment = treatmentInput.getTreatment();

        if(doctorRepository.findById(doctor_Id).isPresent()){
            Set<Doctor> temp = new HashSet<>(Collections.emptySet());
            temp.add(doctorRepository.findById(doctor_Id).get());
            treatment.setTreatsDoctors(temp);
        }else{
            return -1;
        }
        if(patientRepository.findById(patientId).isPresent()){
            Set<Patient> temp = new HashSet<>(Collections.emptySet());
            temp.add(patientRepository.findById(patientId).get());
            treatment.setPatientTreatmentPatients(temp);
        }else{
            return -1;
        }


        Set<Medicine> medicines = new HashSet<Medicine>();
        for(int t : medicineId){
            if(medicineRepository.findById(t).isPresent()){
                medicines.add(medicineRepository.findById(t).get());
            }
            else{
                return -1;
            }
        }
        treatment.setIncludesMedicines(medicines);

        Treatment newTreatment = treatmentRepository.save(treatment);

        for(int t : testId){
            Test test1 = new Test();
            Test_IDs testIDs = new Test_IDs();
            testIDs.setTreatmentID(newTreatment.getTreatmentId());
            testIDs.setLaboratoryId(t);
            test1.setDate(new Date());
            test1.setId(testIDs);
            int price;
            if(t == 1) price = 200;
            else if (t == 2) price = 2000;
            else if (t == 3) price = 700;
            else if (t == 4) price = 750;
            else if (t == 5) price = 1200;
            else if (t == 6) price = 500;
            else price = 0;
            test1.setPrice(price);
            testRepository.save(test1);
        }

        return newTreatment.getTreatmentId();
    }

    public String updateTreatment(Integer id, Treatment patch) throws ParseException {
        Treatment treatment = treatmentRepository.getOne(id);
        if(patch.getIncludesMedicines() != null){
            treatment.setIncludesMedicines(patch.getIncludesMedicines());
        }
        if(patch.getDescription() != null){
            treatment.setDescription(patch.getDescription());
        }
        if(patch.getProblem() !=null){
            treatment.setProblem(patch.getProblem());
        }
        if(patch.getDate() !=null){
            treatment.setDate(patch.getDate());
        }

        treatmentRepository.save(treatment);
        return "Success";
    }
}
