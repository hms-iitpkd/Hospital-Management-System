package com.iitpkd.hospitalManagement.App.repositories;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.util.Optional;

@Repository
@Transactional
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Optional<Doctor> findByName(String name);
}
