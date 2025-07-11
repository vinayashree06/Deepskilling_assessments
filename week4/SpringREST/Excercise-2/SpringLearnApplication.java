package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.debug("START");
		displayCountry();
		LOGGER.debug("END");
	}

	public static void displayCountry() {
		System.out.println(">>> Inside displayCountry()");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		System.out.println(">>> context loaded: " + context);

		System.out.println(">>> Bean names in context:");
		String[] beanNames = context.getBeanDefinitionNames();
		for (String name : beanNames) {
			System.out.println(name);
		}

		Country country = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		System.out.println(">>> Country: " + country.toString());
	}
}
