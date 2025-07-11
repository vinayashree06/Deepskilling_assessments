package com.cognizant.spring_learn;

import com.cognizant.spring_learn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);

		displayCountry(); // This will run after web server is up
	}

	public static void displayCountry() {
		LOGGER.debug(">>> Inside displayCountry()");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		LOGGER.debug(">>> context loaded: {}", context);
		for (String name : context.getBeanDefinitionNames()) {
			LOGGER.debug(">>> Bean: {}", name);
		}

		Country country = context.getBean("country", Country.class);
		LOGGER.debug(">>> Loaded country bean: {}", country);
	}
}
