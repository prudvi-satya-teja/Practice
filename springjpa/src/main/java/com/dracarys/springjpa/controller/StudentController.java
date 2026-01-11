package com.dracarys.springjpa.controller;


import com.dracarys.springjpa.entity.Student;
import com.dracarys.springjpa.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student s = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @PostMapping("/")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.save(student);
        Student s = studentService.getStudentById(student.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }


}
