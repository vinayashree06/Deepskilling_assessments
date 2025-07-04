package com.cognizant.orm.learn;

import com.cognizant.orm.learn.model.Country;
import com.cognizant.orm.learn.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		LOGGER.info("Inside main");
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("START");

		Optional<Country> result = countryRepository.findById("IN");
		if (result.isPresent()) {
			Country country = result.get();
			LOGGER.info("Country: {}", country);

			// Plain console output:
			System.out.println("Country details: " + country);
			System.out.println("Country name: " + country.getName());
		} else {
			LOGGER.warn("Country with code IN not found!");
			System.out.println("Country with code IN not found!");
		}

		LOGGER.info("END");
	}
}
