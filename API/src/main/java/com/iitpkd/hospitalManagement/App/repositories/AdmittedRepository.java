package com.iitpkd.hospitalManagement.App.repositories;

import com.iitpkd.hospitalManagement.App.dto.Admitted;
import com.iitpkd.hospitalManagement.App.dto.Visiting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AdmittedRepository extends JpaRepository<Admitted, Integer> {

    @Query(value = "SELECT * FROM Admitted\n" +
            "WHERE Admitted.Date_of_Disharge is NULL",
            nativeQuery = true)
    List<Admitted> getCurrentAdmissions();
}
