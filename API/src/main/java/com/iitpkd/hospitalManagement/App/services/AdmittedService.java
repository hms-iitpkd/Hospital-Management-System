package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.Admitted;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.JsonPatch;
import com.iitpkd.hospitalManagement.App.dto.Patient;
import com.iitpkd.hospitalManagement.App.dto.Ward;
import com.iitpkd.hospitalManagement.App.repositories.AdmittedRepository;
import com.iitpkd.hospitalManagement.App.repositories.PatientRepository;
import com.iitpkd.hospitalManagement.App.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AdmittedService {
    @Autowired
    private AdmittedRepository admittedRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private WardRepository wardRepository;

    public List<Admitted> getAllAdmitted(){
        List<Admitted> patients = new ArrayList<>();
        admittedRepository.findAll().forEach(patients::add);
        for (Admitted patient : patients) {
            Set<Patient> Temp = new HashSet<>(Collections.emptySet());
            for (Patient pt : patient.getStayPatients()) {
                pt.setPatientAppointments(null);
                pt.setPatientTreatmentTreatments(null);
                Temp.add(pt);
            }
            patient.setStayPatients(Temp);
        }
        return patients;
    }

    public Optional<Admitted> getAdmitted(Integer id){
        Optional<Admitted> optional = admittedRepository.findById(id);
        if (optional.isPresent()) {
            Admitted patient = optional.get();
            Set<Patient> Temp = new HashSet<>(Collections.emptySet());
            for (Patient pt : patient.getStayPatients()) {
                pt.setPatientAppointments(null);
                pt.setPatientTreatmentTreatments(null);
                Temp.add(pt);
            }
            patient.setStayPatients(Temp);
            optional = Optional.ofNullable(patient);
        }
        return optional;
    }

    public List<Admitted> getCurrentAdmitted() {
        List<Admitted> patients = new ArrayList<>();
        admittedRepository.getCurrentAdmissions().forEach(patients::add);
        //admittedRepository.get_visitor_info().forEach(patients::add);
        return patients;
    }

    public Integer postAdmitted(Integer patientId, Integer roomNumber) {

        Admitted newAdmitted = new Admitted();

        if(patientRepository.findById(patientId).isPresent()) {
            Set<Patient> patientSet = new HashSet<>(Collections.emptySet());
            patientSet.add(patientRepository.findById(patientId).get());
            newAdmitted.setStayPatients(patientSet);
        }else{
            return -1;
        }

        if(wardRepository.findById(roomNumber).isPresent()) {
            Set<Ward> wardSet = new HashSet<>(Collections.emptySet());
            Ward ward = wardRepository.findById(roomNumber).get();
            ward.setBedsAvailable(ward.getBedsAvailable() - 1);
            wardSet.add(ward);
            newAdmitted.setAdmRoomWards(wardSet);
        }else {
            return -1;
        }

        newAdmitted.setAdmissionVisitings(null);

        if (newAdmitted.getDateOfAdmission() == null) {
            newAdmitted.setDateOfAdmission(new Date());
        }

        Admitted admitted = admittedRepository.save(newAdmitted);
        return admitted.getAdmissionId();
    }

    public String updateAdmitted(Integer id, Admitted patch) throws ParseException {
            Admitted admitted = admittedRepository.getOne(id);
            if(patch.getDateOfDisharge() != null){
                admitted.setDateOfDisharge(patch.getDateOfDisharge());
            }
            if(patch.getDateOfAdmission() != null){
                admitted.setDateOfAdmission(patch.getDateOfAdmission());
            }
            if(patch.getAdmRoomWards()!=null){
                admitted.setAdmRoomWards(patch.getAdmRoomWards());
            }
            admittedRepository.save(admitted);
            return "Success";
    }
}
