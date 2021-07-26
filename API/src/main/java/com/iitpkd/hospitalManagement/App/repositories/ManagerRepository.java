package com.iitpkd.hospitalManagement.App.repositories;


import com.iitpkd.hospitalManagement.App.dto.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Optional<Manager> findByName(String name);
}
