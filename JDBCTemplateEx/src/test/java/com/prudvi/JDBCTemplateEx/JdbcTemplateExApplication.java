package com.prudvi.JDBCTemplateEx;

import com.prudvi.JDBCTemplateEx.Repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class JdbcTemplateExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JdbcTemplateExApplication.class, args);

//		Student student = context.getBean(Student.class);
//		student.setName("raj");
//		student.setRollno(4);
//		student.setPassword(4);
//		StudentService studentService = context.getBean(StudentService.class);
//		studentService.saveStudent(student);
//		System.out.println(studentService.getAllStudent());

		StudentRepository studentRepository = context.getBean(StudentRepository.class);
//		studentRepository.createTable();

		System.out.println(studentRepository.getData());
		System.out.println(studentRepository.getAllNames());
		System.out.println(studentRepository.getById(1).toString());


	}

}
