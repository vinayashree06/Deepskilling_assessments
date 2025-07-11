package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
        System.out.println(">>> Inside Country Constructor");
    }

    public void setCode(String code) {
        LOGGER.debug("Inside setCode()");
        System.out.println(">>> Inside setCode()");
        this.code = code;
    }

    public String getCode() {
        LOGGER.debug("Inside getCode()");
        System.out.println(">>> Inside getCode()");
        return code;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName()");
        System.out.println(">>> Inside setName()");
        this.name = name;
    }

    public String getName() {
        LOGGER.debug("Inside getName()");
        System.out.println(">>> Inside getName()");
        return name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
