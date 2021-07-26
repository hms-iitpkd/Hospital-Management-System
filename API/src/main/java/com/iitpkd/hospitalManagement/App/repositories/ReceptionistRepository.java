package com.iitpkd.hospitalManagement.App.repositories;

import com.iitpkd.hospitalManagement.App.dto.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface ReceptionistRepository extends JpaRepository<Receptionist, Integer> {
    Optional<Receptionist> findByName(String name);
}
