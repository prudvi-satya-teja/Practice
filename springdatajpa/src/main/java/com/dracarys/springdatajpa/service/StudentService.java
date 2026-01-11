package com.dracarys.springdatajpa.service;

import com.dracarys.springdatajpa.entity.Student;
import com.dracarys.springdatajpa.repository.EmployeeRepository;
import com.dracarys.springdatajpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentService {

    StudentRepository studentRepository;

    EmployeeRepository employeeRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, EmployeeRepository employeeRepository) {
        this.studentRepository = studentRepository;
        this.employeeRepository = employeeRepository;
    }

    public Student getStudentDetails(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public boolean deleteStudentByID(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.delete(student.get());
            return true;
        }
        else {
            return false;
        }
    }

    public void addStudents(List<Student> students) {
        studentRepository.saveAll(students);

    }

//    public Student addStudent(Student student) {
//        // System.out.println(student);
//        if (student.getEmployee() != null && student.getEmployee().getId() != 0) {
//            Employee emp = employeeRepository.findById(student.getEmployee().getId())
//                    .orElseThrow(() -> new RuntimeException("Employee not found"));
//            student.setEmployee(emp); // set managed entity
//        }
//
//
//        Student st = studentRepository.save(student);
//        System.out.println(st);
//        return st;
//
//    }



}
