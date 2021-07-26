package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.Admitted;
import com.iitpkd.hospitalManagement.App.dto.Appointment;
import com.iitpkd.hospitalManagement.App.dto.IDClasses.Appointment_IDs;
import com.iitpkd.hospitalManagement.App.repositories.AppointmentRepository;
import com.iitpkd.hospitalManagement.App.repositories.DoctorRepository;
import com.iitpkd.hospitalManagement.App.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;


    public List<Appointment> getAllAppointments(){
        return new ArrayList<>(appointmentRepository.findAll());
    }

    public Optional<Appointment> getAppointment(Date ID){
        return appointmentRepository.findById(ID);
    }

    public String postAppointment(Date time, Integer patient_id, Integer doctor_id) {

        Appointment_IDs appointment_iDs = new Appointment_IDs();
        appointment_iDs.setDoctor_ID(doctor_id);
        appointment_iDs.setDate_Time(Objects.requireNonNullElseGet(time, Date::new));
        appointment_iDs.setPatient_ID(patient_id);

        Appointment newAppointment = new Appointment();
        newAppointment.setId(appointment_iDs);
        if(patientRepository.findById(patient_id).isPresent()){
            newAppointment.setPatient(patientRepository.findById(patient_id).get());
        }else{
            return "No Such Patient";
        }

        if(doctorRepository.findById(doctor_id).isPresent()){
            newAppointment.setDoctor(doctorRepository.findById(doctor_id).get());
        }else{
            return "No Such Doctor";
        }

        appointmentRepository.save(newAppointment);
//        Appointment newAppointment = new Appointment();
//
//        Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(time);
//
//        newAppointment.setDateTime(date1);
//        newAppointment.setDoctor(doctorService.getDoctor(doctor_id).get());
//        newAppointment.setPatient(patientService.getPatient(patient_id).get());
//
//        Appointment appointment =  appointmentRepository.save(newAppointment);
        return "Success";
    }
}
