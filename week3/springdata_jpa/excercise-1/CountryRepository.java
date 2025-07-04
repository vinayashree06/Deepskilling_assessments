package com.cognizant.orm.learn.repository;

import com.cognizant.orm.learn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}
