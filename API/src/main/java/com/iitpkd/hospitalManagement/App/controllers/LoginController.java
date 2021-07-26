package com.iitpkd.hospitalManagement.App.controllers;

import com.iitpkd.hospitalManagement.App.dto.*;
import com.iitpkd.hospitalManagement.App.dto.NonEntities.Authorization;
import com.iitpkd.hospitalManagement.App.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path="/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private NurseService nurseService;

    @Autowired
    private ReceptionistService receptionistService;

    @Autowired
    private ChemistService chemistService;

    @RequestMapping(method= RequestMethod.GET, produces={"application/json"})
    public LoginOut getLogin(@RequestParam("email") String email,
                          @RequestParam("pwd") String pwd){
        return loginService.getLoginDetails(email, pwd);
    }

    @RequestMapping(path="/register", method=RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public Integer postLogin(@RequestBody LoginEmployee loginEmployee){
        if(Authorization.getAccess_level()!=0){
            return null;
        }
        Login login = loginEmployee.getLogin();
        Employee employee = loginEmployee.getEmployee();
        loginService.addLogin(login);
        int employeeId =  employeeService.postEmployee(employee);

        int type = login.getAccessLevel();
        if(type == 0){
            Manager manager = new Manager();
            manager.setName(login.getName());
            Set<Employee> set = new HashSet<Employee>();
            set.add(new Employee(employeeId));
            manager.setMJobEmployees(set);
            managerService.postManager(manager);
        }
        else if(type == 1){
            Doctor doctor = new Doctor();
            doctor.setName(login.getName());
            Set<Employee> set = new HashSet<Employee>();
            set.add(new Employee(employeeId));
            doctor.setDJobEmployees(set);
            doctorService.postDoctor(doctor);
        }
        else if(type == 2){
            Receptionist receptionist = new Receptionist();
            receptionist.setName(login.getName());
            Set<Employee> set = new HashSet<Employee>();
            set.add(new Employee(employeeId));
            receptionist.setRJobEmployees(set);
            receptionistService.postReceptionist(receptionist);
        }
        else if(type == 3){
            Nurse nurse = new Nurse();
            nurse.setName(login.getName());
            Set<Employee> set = new HashSet<Employee>();
            set.add(new Employee(employeeId));
            nurse.setNJobEmployees(set);
            nurseService.postNurse(nurse);
        }
        else if(type == 4){
            Chemist chemist = new Chemist();
            chemist.setName(login.getName());
            Set<Employee> set = new HashSet<Employee>();
            chemist.setChJobEmployees(set);
            set.add(new Employee(employeeId));
            chemistService.postChemist(chemist);
        }


        return employeeId;
    }

    @RequestMapping(path="/update", method=RequestMethod.PATCH,
            consumes = {"application/json"}, produces = {"application/json"})
    public String updateLogin(@RequestParam("email") String email,
                              @RequestParam("pwd") String pwd,
                              @RequestBody Login login){
        return loginService.updateLogin(email, pwd, login);
    }
}
