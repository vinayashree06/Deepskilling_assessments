package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {
	public static void main(String[] args) {
		System.out.println("Application starting...");
		SpringApplication.run(SpringLearnApplication.class, args);
	}
}

@SpringBootApplication includes:
@Configuration: Declares configuration class.
@EnableAutoConfiguration: Enables Spring Boot's auto-setup.
@ComponentScan: Automatically detects components in the package.
