package com.example.datajpapractice.controller;



import com.example.datajpapractice.entity.Department;
import com.example.datajpapractice.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;



@RestController
@RequestMapping("/api")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> save(@RequestBody Department department) {
        Department createdDepartment = departmentService.save(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);
    }

    @PostMapping("/departments/all")
    public ResponseEntity<List<Department>> saveAll(@Valid @RequestBody List<Department> departments) {
        List<Department> createdDepartments = departmentService.saveAll(departments);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartments);
    }
}
