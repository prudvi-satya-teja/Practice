package com.example.datajpapractice.controller;

import com.example.datajpapractice.entity.Employee;
import com.example.datajpapractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @PostMapping("/employees/all")
    public ResponseEntity<List<Employee>> saveAll(@RequestBody List<Employee> employees) {
        List<Employee> createdEmployees = employeeService.saveAll(employees);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployees);
    }


    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> findEmployees(@RequestParam(required=false, name="name") String name,
                                                        @RequestParam(required = false, name="email") String email,
                                                        @RequestParam(required = false, name="minimumSalary") Double minSalary,
                                                        @RequestParam(required = false, name="maximumSalary") Double maxSalary,
                                                        @RequestParam(required = false, name="departmentId") Long departmentId,
                                                         Pageable pageable) {
        List<Employee> employees = employeeService.searchEmployee(name, minSalary, maxSalary, email, departmentId, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

}
