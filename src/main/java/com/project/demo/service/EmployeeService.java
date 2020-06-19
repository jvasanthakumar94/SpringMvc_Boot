package com.project.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.project.demo.Repository.EmployeeRepo;
import com.project.demo.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	//@CacheEvict(cacheNames="id", key ="#root.args[0].id")
	@Caching(evict = {
			@CacheEvict(cacheNames="getAllCache", allEntries = true),
			@CacheEvict(cacheNames="name", allEntries = true),
			@CacheEvict(cacheNames="id", allEntries = true) })
	public Employee addEmployee(Employee e) {

		System.out.println("in addEmployee"+e);
		employeeRepo.save(e);
		return e;

	}

	@Cacheable(cacheNames = "getAllCache")
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();

	}

	@Cacheable(cacheNames = "id")
	public Optional<Employee> getEmployee(int id) {
		System.out.println("in getEmployee not cached");
		return employeeRepo.findById(id);

	}

	@Cacheable(cacheNames = "name")
	public List<Employee> getEmployeeByName(String name) {

		return employeeRepo.findByName(name);
	}


	@Caching(evict = {
			@CacheEvict(cacheNames="getAllCache", allEntries = true),
			@CacheEvict(cacheNames="name", allEntries = true),
			@CacheEvict(cacheNames="id", allEntries = true) })
	public void deleteEmployee(int id) {
		employeeRepo.deleteById(id);
	}

	public String test() {
		System.out.println("kkkkkkk");
		return "test";
	}

	public List<Employee> getEmployeeGreaterThanId(int id) {
		// TODO Auto-generated method stub
		return employeeRepo.findAll()
				.stream()
				.filter(p -> p.getId() > id)
				.collect(Collectors.toList());
	}

	public List<Employee> getEmployeeSortById() {
		List<Employee> list= employeeRepo.findAll();
		list.sort((Employee e1 , Employee e2) -> e2.getId() - e1.getId());
		 return list;
				
	}

	public  List<Employee> getEmployeeSortByNameDesc() {
		List<Employee> list= employeeRepo.findAll();
		list.sort((Employee e1 , Employee e2) -> e2.getName().compareTo(e1.getName()));
		 return list;
	}

}
