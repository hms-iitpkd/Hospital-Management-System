package com.iitpkd.hospitalManagement.App.repositories;

import com.iitpkd.hospitalManagement.App.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM Employee\n" +
            "ORDER BY ?1",
            nativeQuery = true)
    public List<Employee> getSorted(String order);

    @Query(value = "SELECT e FROM Employee e\n" +
            "WHERE e.Department = ?2\n"+
            "ORDER BY ?1",
            nativeQuery = true)
    public List<Employee> getDeptWise(String order, String dept);

}
