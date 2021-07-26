package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.Bill;
import com.iitpkd.hospitalManagement.App.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public List<Bill> getAllBills(){
        return new ArrayList<>(billRepository.findAll());
    }

    public Optional<Bill> getBill(Integer bill_id){
        return billRepository.findById(bill_id);
    }

    public Integer addBill(Bill bill) {
        if(bill.getDate()==null){
            bill.setDate(new Date());
        }
        bill.setBillPayments(null);
        Bill b = billRepository.save(bill);
        return b.getBillId();
    }

//    public Integer addBill(Bill bill){
//        Bill b = billRepository.save(bill);
//        return b.getBillId();
//    }
}
