package com.dracarys.springdatajpa.service;


import com.dracarys.springdatajpa.Util.EmployeeResponse;
import com.dracarys.springdatajpa.entity.Employee;
import com.dracarys.springdatajpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EmployeeService {

    public EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponse add(Employee employee) {
        Employee em =  employeeRepository.save(employee);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        em.setName(em.getName());

        Link verifyLink = WebMvcLinkBuilder.linkTo(EmployeeResponse.class).slash("/add-customer").withRel("verify").withType("POST");

        employeeResponse.setLinks(Arrays.asList(verifyLink));
        System.out.println(verifyLink + " " + employeeResponse.toString());
        return employeeResponse;

    }
}
