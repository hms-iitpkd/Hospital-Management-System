package com.iitpkd.hospitalManagement.App.repositories;

import com.iitpkd.hospitalManagement.App.dto.Admitted;
import com.iitpkd.hospitalManagement.App.dto.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface VisitorRepository extends JpaRepository<Visitor, Integer> {
}
