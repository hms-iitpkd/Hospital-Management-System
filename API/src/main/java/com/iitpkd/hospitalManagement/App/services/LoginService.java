package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.Login;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.repositories.LoginRepository;
import com.iitpkd.hospitalManagement.App.dto.*;
import com.iitpkd.hospitalManagement.App.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private ChemistRepository chemistRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ReceptionistRepository receptionistRepository;

    public LoginOut getLoginDetails(String email, String pwd){
        if(loginRepository.findById(email).isPresent()){
            Login login = loginRepository.findById(email).get();
            int type = login.getAccessLevel();
            int id = -1;
            if (login.getPassword().equals(pwd)){
                Authorization.setAccess_level(login.getAccessLevel());
                login.setLastLogin(new Date());
                loginRepository.save(login);

                if(type == 0){
                    Optional<Manager> doctor =  managerRepository.findByName(login.getName());
                    if(doctor.isPresent()){
                        id = doctor.get().getManagerId();
                    }
                }
                else if(type == 1){
                    Optional<Doctor> doctor =  doctorRepository.findByName(login.getName());
                    if(doctor.isPresent()){
                        id = doctor.get().getDoctorId();
                    }
                }
                else if(type == 2){
                    Optional<Nurse> doctor =  nurseRepository.findByName(login.getName());
                    if(doctor.isPresent()){
                        id = doctor.get().getNurseId();
                    }
                }
                else if(type == 4){
                    Optional<Chemist> doctor =  chemistRepository.findByName(login.getName());
                    if(doctor.isPresent()){
                        id = doctor.get().getChemistId();
                    }
                }
                else if(type == 3){
                    Optional<Receptionist> doctor =  receptionistRepository.findByName(login.getName());
                    if(doctor.isPresent()){
                        id = doctor.get().getReceptionistId();
                    }
                }
                return new LoginOut(login, id);
            }else{
                return null;
            }
        }
        else{
            return null;
        }
    }

    public String addLogin(Login login){
        Login new_login = loginRepository.save(login);
        return new_login.getEmailId();
    }

    public String updateLogin(String email, String pwd, Login patch){
        if(loginRepository.findById(email).isPresent()){
            Login login = loginRepository.findById(email).get();
            if(!login.getPassword().equals(pwd)){
                return "Not Authorized";
            }
            if(patch.getPassword() != null){
                login.setPassword(patch.getPassword());
            }
            if(patch.getAccessLevel() != null){
                login.setAccessLevel(patch.getAccessLevel());
            }
            if(patch.getName() != null){
                login.setName(patch.getName());
            }
            if(patch.getContactNumber() != null){
                login.setContactNumber(patch.getContactNumber());
            }
            if(patch.getAccountType() != null){
                login.setAccountType(patch.getAccountType());
            }
            loginRepository.save(login);
            return "Success";
        }else{
            return "Not Found";
        }
    }
}
