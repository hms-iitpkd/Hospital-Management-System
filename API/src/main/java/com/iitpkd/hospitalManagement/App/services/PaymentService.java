package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.IDClasses.Payment_IDs;
import com.iitpkd.hospitalManagement.App.dto.Payment;
import com.iitpkd.hospitalManagement.App.dto.Treatment;
import com.iitpkd.hospitalManagement.App.repositories.BillRepository;
import com.iitpkd.hospitalManagement.App.repositories.PaymentRepository;
import com.iitpkd.hospitalManagement.App.repositories.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Autowired
    private BillRepository billRepository;

    public String addPayment(Integer treatmentId, Integer billId, String modeOfPayment){
        Payment_IDs payment_iDs = new Payment_IDs();
        payment_iDs.setTreatment_ID(treatmentId);
        Payment payment = new Payment();
        payment.setModeOfPayment(modeOfPayment);
        payment.setId(payment_iDs);

        if(treatmentRepository.findById(treatmentId).isPresent()){
            payment.setTreatment(treatmentRepository.findById(treatmentId).get());
        }
        else{
            return "No Treatment Found";
        }
        if(billRepository.findById(billId).isPresent()){
            payment.setBill(billRepository.findById(billId).get());
        }
        else{
            return "No Bill Found";
        }
        paymentRepository.save(payment);
        return "Success";
    }


}
