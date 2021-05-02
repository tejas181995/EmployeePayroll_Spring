package com.bridgelabz.employeepayrollspring;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@Slf4j
public class EmployeePayrollAppSpringApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = 
				SpringApplication.run(EmployeePayrollAppSpringApplication.class, args);
		log.info("Employee payroll app started in {} Environment", 
				context.getEnvironment().getProperty("environment"));
	}
}
