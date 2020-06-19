package com.project.demo.controller;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LogAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);
    
	//getEmployees
	@Before("execution(public * com.project.demo.controller.EmployeeRestController.getEmployees())")
	public void logBeforeEmployees() {
		LOGGER.info("getEmployees execution started");
	}
	
	@AfterReturning("execution(public * com.project.demo.controller.EmployeeRestController.getEmployees())")
	public void logAfterEmployees() {
		LOGGER.info("getEmployees execution completed");
	}
	@AfterThrowing("execution(public * com.project.demo.controller.EmployeeRestController.getEmployees())")
	public void logThrowingEmployees() {
		LOGGER.info("getEmployees execution failed");
	}
	
	
	//getEmployee
	@Before("execution(public * com.project.demo.controller.EmployeeRestController.getEmployee(..))")
	public void logBeforeEmployee() {
		LOGGER.info("getEmployee execution started");
	}
	
	@AfterReturning("execution(public * com.project.demo.controller.EmployeeRestController.getEmployees())")
	public void logAfterEmployee() {
		LOGGER.info("getEmployee execution completed");
	}
	@AfterThrowing("execution(public * com.project.demo.controller.EmployeeRestController.getEmployees())")
	public void logThrowingEmployee() {
		LOGGER.info("getEmployee execution failed");
	}
}
