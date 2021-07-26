package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.Ward;
import com.iitpkd.hospitalManagement.App.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WardService {

    @Autowired
    private WardRepository wardRepository;

    public List<Ward> getAllWards(){ return new ArrayList<>(wardRepository.findAll()); }
    public Optional<Ward> getWard(Integer room_no){
        return wardRepository.findById(room_no);
    }

    public Integer addWard(Ward ward){
        ward.setAdmRoomAdmitteds(null);
        ward.setRoomNumberWardDutys(null);
        Ward newWard = wardRepository.save(ward);
        return newWard.getRoomNumber();
    }

    public String updateWard(Integer id, Ward patch) throws ParseException {
        Ward ward = wardRepository.getOne(id);
        if(patch.getOccupancy() != null){
            ward.setOccupancy(patch.getOccupancy());
        }
        if(patch.getBedsAvailable() != null){
            ward.setBedsAvailable(patch.getBedsAvailable());
        }
        if(patch.getRoomNumberWardDutys() !=null){
            ward.setRoomNumberWardDutys(patch.getRoomNumberWardDutys());
        }

        wardRepository.save(ward);
        return "Success";
    }

    public Integer getEmptyWard(){
        return wardRepository.getRoom();
    }
}
