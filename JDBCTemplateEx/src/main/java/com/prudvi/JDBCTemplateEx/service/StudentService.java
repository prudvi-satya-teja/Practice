package com.prudvi.JDBCTemplateEx.service;

import com.prudvi.JDBCTemplateEx.Repository.StudentRepository;
import com.prudvi.JDBCTemplateEx.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service
public class StudentService {

    StudentRepository studentRepository;

    StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    public void saveStudent(Student student) {
//        studentRepository.saveStudent(student);
//    }
//
//    public List<Student> getAllStudent() {
//        return studentRepository.getAllStudent();
//    }

}
