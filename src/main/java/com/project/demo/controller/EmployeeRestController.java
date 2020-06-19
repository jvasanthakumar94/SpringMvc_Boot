package com.project.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Employee;
import com.project.demo.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("insertEmployee")
	public Employee addEmployee(@RequestBody Employee e) {
		System.out.println("in insertEmployee");
		return  employeeService.addEmployee(e);
	}
    
	@GetMapping("/employee/id/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}
	
	@GetMapping("/employee/name/{name}")
	public List<Employee> getEmployee(@PathVariable String name) {
		return employeeService.getEmployeeByName(name);
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@DeleteMapping("/employee/id/{id}")
	public String deleteEmployee(@PathVariable int id) {
		 employeeService.deleteEmployee(id);
		 return "Employee " + id + " deleted";
	}
	
	@GetMapping("/test")
	public String test() {
		System.out.println("test");
		return employeeService.test();
	}
}
