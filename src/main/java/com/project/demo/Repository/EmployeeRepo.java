package com.project.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	List<Employee> findByName(String name);

}
