package com.iitpkd.hospitalManagement.App.repositories;

import com.iitpkd.hospitalManagement.App.dto.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {
}
