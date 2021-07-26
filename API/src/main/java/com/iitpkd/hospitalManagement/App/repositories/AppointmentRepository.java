package com.iitpkd.hospitalManagement.App.repositories;

import com.iitpkd.hospitalManagement.App.dto.Appointment;
import com.iitpkd.hospitalManagement.App.dto.IDClasses.Appointment_IDs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
@Transactional
public interface AppointmentRepository extends JpaRepository<Appointment, Date> {
}
