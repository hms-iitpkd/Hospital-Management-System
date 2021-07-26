package com.iitpkd.hospitalManagement.App.services;


import com.iitpkd.hospitalManagement.App.dto.Admitted;
import com.iitpkd.hospitalManagement.App.dto.Appointment;
import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors(){
        return new ArrayList<>(doctorRepository.findAll());
    }

    public Optional<Doctor> getDoctor(Integer id) {
        return doctorRepository.findById(id);
    }

    // To be checked
    public Integer postDoctor(Doctor newDoctor) {
        Doctor doctor = doctorRepository.save(newDoctor);
        return doctor.getDoctorId();
    }

    public String updateDoctor(Integer id, Doctor patch) throws ParseException {
        Doctor doctor = doctorRepository.getOne(id);
        if(patch.getConsultancyFees() != null){
            doctor.setConsultancyFees(patch.getConsultancyFees());
        }
        if(patch.getDepartment() != null){
            doctor.setDepartment(patch.getDepartment());
        }

        if(patch.getRoomNo() !=null){
            doctor.setRoomNo(patch.getRoomNo());
        }
        if(patch.getShift() !=null){
            doctor.setShift(patch.getShift());
        }
        doctorRepository.save(doctor);
        return "Success";
    }
}

