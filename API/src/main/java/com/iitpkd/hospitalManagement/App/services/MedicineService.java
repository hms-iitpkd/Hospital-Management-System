package com.iitpkd.hospitalManagement.App.services;


import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.Medicine;
import com.iitpkd.hospitalManagement.App.repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;

    public List<Medicine> getAllMedicine(){
        return new ArrayList<>(medicineRepository.findAll());
    }

    public Optional<Medicine> getMedicine(Integer id){
        return medicineRepository.findById(id);
    }

    //to be checked
    public Integer postMedicine(Medicine newMedicine) {
        newMedicine.setIncludesTreatments(null);
        Medicine medicine = medicineRepository.save(newMedicine);
        return medicine.getMedicineId();
    }

    public String updateMedicine(Integer id, Medicine patch) throws ParseException {
        Medicine medicine = medicineRepository.getOne(id);
        if(patch.getPrice() != null){
            medicine.setPrice(patch.getPrice());
        }
        if(patch.getVendor() != null){
            medicine.setVendor(patch.getVendor());
        }
        medicineRepository.save(medicine);
        return "Success";
    }
}
