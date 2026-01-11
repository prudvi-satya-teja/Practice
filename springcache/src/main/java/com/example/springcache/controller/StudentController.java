package com.example.springcache.controller;


import com.example.springcache.entity.Student;
import com.example.springcache.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    StudentService studentService;

    @Autowired
    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
        studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Void> updateStudent(@RequestBody Student student, @PathVariable Long id) {
        studentService.update(student, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public String hey() {
        return "hey";
    }

}
