package com.iitpkd.hospitalManagement.App.repositories;

import com.iitpkd.hospitalManagement.App.dto.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
