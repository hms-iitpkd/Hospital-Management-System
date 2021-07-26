package com.iitpkd.hospitalManagement.App.repositories;

import com.iitpkd.hospitalManagement.App.dto.IDClasses.Ward_Duty_IDs;
import com.iitpkd.hospitalManagement.App.dto.WardDuty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface WardDutyRepository extends JpaRepository<WardDuty, Ward_Duty_IDs> {
}
