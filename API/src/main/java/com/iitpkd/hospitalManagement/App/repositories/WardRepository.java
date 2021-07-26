package com.iitpkd.hospitalManagement.App.repositories;

import com.iitpkd.hospitalManagement.App.dto.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface WardRepository extends JpaRepository<Ward, Integer> {

    @Query(value = "SELECT empty_ward()",
            nativeQuery = true)
    public Integer getRoom();
}
