package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.demo.model.Employee;
import com.project.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@PostMapping(value="addEmployee")
	public String addEmployee(@ModelAttribute("employee") Employee e) {
		System.out.println("in addEmployee"+e);
		 employeeService.addEmployee(e);
		 return "output";
		
	}
	
	@GetMapping(value="getEmployees")
	public String getAllEmployees(Model m) {
		System.out.println("in getAllEmployees");
		List<Employee> Employeelist = employeeService.getAllEmployees();
		 m.addAttribute("employee", Employeelist);
		 return "output";
	}
	
	@GetMapping(value="getEmployee")
	public String getEmployee(@RequestParam int id,Model m) {
		m.addAttribute("employee", employeeService.getEmployee(id).orElse(null));
		return "output";
	}
	
	@GetMapping(value="getEmployeeByName")
	public String getEmployeeByName(@RequestParam String name, Model m) {
		m.addAttribute("employee", employeeService.getEmployeeByName(name));
		return "output";
	}
	
	@PostMapping(value="deleteEmployee")
	public String deleteEmployeeById(@RequestParam int id, Model m) {
		 employeeService.deleteEmployee(id);
		m.addAttribute("employee","Employee "+id+" deleted");
		return "output";
	}
	
	
	@GetMapping(value="getEmployeeGreaterThanId")
	public String getEmployeeGreaterThanId(@RequestParam int id,Model m) {
		m.addAttribute("employee", employeeService.getEmployeeGreaterThanId(id));
		return "output";
	}
	
	
	@GetMapping(value="getEmployeeSortById")
	public String getEmployeeSortById(Model m) {
		m.addAttribute("employee", employeeService.getEmployeeSortById());
		return "output";
	}
	
	@GetMapping(value="getEmployeeSortByNameDesc")
	public String getEmployeeSortByNameDesc(Model m) {
		m.addAttribute("employee", employeeService.getEmployeeSortByNameDesc());
		return "output";
	}

}
