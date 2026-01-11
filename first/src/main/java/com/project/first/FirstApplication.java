package com.project.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirstApplication.class, args);

		Hello hell = context.getBean(Hello.class);
		hell.hello();
	}

}
