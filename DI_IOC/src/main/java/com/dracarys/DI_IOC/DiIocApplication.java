package com.dracarys.DI_IOC;

import Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiIocApplication {

	public static void main(String[] args) {
		System.out.println("Di Ioc Application Started");

		ApplicationContext context = SpringApplication.run(DiIocApplication.class, args);

		Student student = (Student) context.getBean("prudvi");
		System.out.println("Student name is " + student.getName());
	}

}
