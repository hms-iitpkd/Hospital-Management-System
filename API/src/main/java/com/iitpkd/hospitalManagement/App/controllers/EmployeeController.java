package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.Doctor;
import com.iitpkd.hospitalManagement.App.dto.Employee;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method= RequestMethod.GET, produces = {"application/json"})
    public List<Employee> getAllEmployees(@RequestParam(required = false, defaultValue = "Employee_ID") String sort,
                                          @RequestParam(required = false) String dept){
        if(Authorization.getAccess_level()!=0){
            return null;
        }
        if(dept == null) {
            return employeeService.sortEmployeesBySalary(sort);
        }
        else{
            return employeeService.getDeptWise(sort, dept);
        }
    }

    @RequestMapping(path ="/{id}", method= RequestMethod.GET, produces = {"application/json"})
    public Optional<Employee> getEmployee(@PathVariable("id") Integer id){
        if(Authorization.getAccess_level()!=0){
            return Optional.empty();
        }
        return employeeService.getEmployee(id);
    }

    // To be checked
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public Integer addEmployee(@RequestBody Employee employee){
        if(Authorization.getAccess_level()!=0){
            return null;
        }
        return employeeService.postEmployee(employee);
    }

    @RequestMapping(path = "/{id}", method=RequestMethod.PATCH,
            produces={"application/json"}, consumes={"application/json"})
    public String updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) throws ParseException {
        if(Authorization.getAccess_level()!=0){
            return null;
        }
        return employeeService.updateEmployee(id, employee);

    }
}
