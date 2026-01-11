package com.example.springcache.service;


import com.example.springcache.entity.Student;
import com.example.springcache.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void update(Student student, Long id) {
        Student student1 = studentRepository.findById(id).orElse(null);

        if(student1 != null){
            student1.setName(student.getName());
            student1.setAge(student.getAge());
            studentRepository.save(student1);
        }
    }
}
