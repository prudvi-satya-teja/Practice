package com.dracarys.springdatajpa.controller;


import com.dracarys.springdatajpa.Util.EmployeeResponse;
import com.dracarys.springdatajpa.entity.Employee;
import com.dracarys.springdatajpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class EmployeeController {

    public EmployeeService employeeService;

    @Autowired
    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add-employee")
    public EmployeeResponse addEmployee(@RequestBody Employee employee) {
        System.out.println("add employee " + employee);
        throw new ArithmeticException("add employee error");
//        return  employeeService.add(employee);
    }
}
