package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.Manager;
import com.iitpkd.hospitalManagement.App.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public List<Manager> getAllManagers(){
        return new ArrayList<>(managerRepository.findAll());
    }

    public Optional<Manager> getManager(Integer id){
        return managerRepository.findById(id);
    }

    // To be checked
    public Integer postManager(Manager newManager) {
        Manager manager = managerRepository.save(newManager);
        return manager.getManagerId();
    }

}
