package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.Patient;
import com.iitpkd.hospitalManagement.App.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return new ArrayList<>(patientRepository.findAll());
    }

    public Optional<Patient> getPatient(Integer id){
        return patientRepository.findById(id);
    }

    //to be checked
    public Integer postPatient(Patient newPatient) {
        newPatient.setStayAdmitteds(null);
        newPatient.setPatientTreatmentTreatments(null);
        newPatient.setPatientAppointments(null);
        Patient patient = patientRepository.save(newPatient);
        return patient.getPatientId();
    }

    public String updatePatient(Integer id, Patient patch) throws ParseException {
        Patient patient = patientRepository.getOne(id);
        if(patch.getAddress() != null){
            patient.setAddress(patch.getAddress());
        }
        if(patch.getContactNumber() != null){
            patient.setContactNumber(patch.getContactNumber());
        }
        if(patch.getName() !=null){
            patient.setName(patch.getName());
        }
        if(patch.getEmailId() !=null){
            patient.setEmailId(patch.getEmailId());
        }
        if(patch.getWeight() !=null){
            patient.setWeight(patch.getWeight());
        }
        if(patch.getAge() != null){
            patient.setAge(patch.getAge());
        }
        if(patch.getHeight() != null){
            patient.setHeight(patch.getHeight());
        }
        if(patch.getGender() != null){
            patient.setGender(patch.getGender());
        }
        patientRepository.save(patient);
        return "Success";
    }
}
