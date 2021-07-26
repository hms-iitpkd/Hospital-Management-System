package com.iitpkd.hospitalManagement.App.repositories;

import com.iitpkd.hospitalManagement.App.dto.IDClasses.Visiting_IDs;
import com.iitpkd.hospitalManagement.App.dto.Visiting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface VisitingRepository extends JpaRepository<Visiting, Visiting_IDs> {
}
