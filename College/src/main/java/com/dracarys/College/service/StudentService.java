package com.dracarys.College.service;


import com.dracarys.College.entity.Student;
import com.dracarys.College.exception.ResourceNotFoundException;
import com.dracarys.College.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()->  new ResourceNotFoundException("Student doesnot exist with the id " + id));
    }

    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Student doesnot exist with the id " + id);
        }
        studentRepository.deleteById(id);
    }

    public Student updateStudentById(Long id, Student student) {
        return studentRepository.findById(id).map(existingStudent-> {
                    existingStudent.setName(student.getName());
                    existingStudent.setPhone(student.getPhone());
                    existingStudent.setEmail(student.getEmail());
                    return studentRepository.save(existingStudent);
                }).
                orElseThrow(()->new ResourceNotFoundException("Student doesnot exist with the id " + id));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
