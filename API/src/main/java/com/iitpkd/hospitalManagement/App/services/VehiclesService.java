package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.Nurse;
import com.iitpkd.hospitalManagement.App.dto.Vehicle;
import com.iitpkd.hospitalManagement.App.repositories.NurseRepository;
import com.iitpkd.hospitalManagement.App.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehiclesService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles(){
        return new ArrayList<>(vehicleRepository.findAll());
    }

    public String updateVehicle(String id, Vehicle patch) throws ParseException {
        Vehicle vehicle = vehicleRepository.getOne(id);
        if(patch.getDescription() != null){
            vehicle.setDescription(patch.getDescription());
        }
        if(patch.getInUse() != null){
            vehicle.setInUse(patch.getInUse());
        }
        if(patch.getType() !=null){
            vehicle.setType(patch.getType());
        }

        vehicleRepository.save(vehicle);
        return "Success";
    }
}
