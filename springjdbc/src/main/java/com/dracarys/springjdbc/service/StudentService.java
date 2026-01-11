package com.dracarys.springjdbc.service;


import com.dracarys.springjdbc.entity.Student;
import com.dracarys.springjdbc.repository.StudentRepository;
import com.dracarys.springjdbc.repository.StudentRepositoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepositoryJDBC studentRepositoryJDBC;

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepositoryJDBC studentRepositoryJDBC, StudentRepository studentRepository) {
        this.studentRepositoryJDBC = studentRepositoryJDBC;
        this.studentRepository = studentRepository;
    }


    public void addStudent(Student student) {
        studentRepository.insertStudent(student);
    }

    public void updateStudent(Student student, int id) {
        studentRepository.updateStudent(student, id);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }

    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }

    public List<Student> getAllStudent() {
        return studentRepository.getAllStudents();
    }
}
