package com.iitpkd.hospitalManagement.App.services;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.Employee;
import com.iitpkd.hospitalManagement.App.dto.EmployeeLogin;
import com.iitpkd.hospitalManagement.App.repositories.EmployeeLoginRepository;
import com.iitpkd.hospitalManagement.App.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeLoginRepository employeeLoginRepository;

    public List<Employee> getAllEmployees(){
        return new ArrayList<>(employeeRepository.findAll());
    }

    public Optional<Employee> getEmployee(Integer id){
        return employeeRepository.findById(id);
    }

    public List<Employee> sortEmployeesBySalary(String order){
        return new ArrayList<>(employeeRepository.getSorted(order));
    }

    public List<Employee> getDeptWise(String order, String dept){
        return new ArrayList<>(employeeRepository.getDeptWise(order, dept));
    }

    // To be checked
    public Integer postEmployee(Employee newEmployee) {
        Employee employee = employeeRepository.save(newEmployee);
        employeeLoginRepository.save(new EmployeeLogin(employee.getEmployeeId(), newEmployee.getEmailId()));
        return employee.getEmployeeId();
    }

    public String updateEmployee(Integer id, Employee patch) throws ParseException {
        Employee employee = employeeRepository.getOne(id);
        if(patch.getName() != null){
            employee.setName(patch.getName());
        }
        if(patch.getAddress() != null){
            employee.setAddress(patch.getAddress());
        }
        if(patch.getAnnualSalary() !=null){
            employee.setAnnualSalary(patch.getAnnualSalary());
        }
        if(patch.getContactNumber() !=null){
            employee.setContactNumber(patch.getContactNumber());
        }
        if(patch.getDateOfTermination()!=null){
            employee.setDateOfTermination(patch.getDateOfTermination());
        }
        employeeRepository.save(employee);
        return "Success";
    }
}
