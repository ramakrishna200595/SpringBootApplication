package com.howtodoinjava.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.demo.model.Employee;
 
@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
	
	public Optional<Employee> getEmployeeByFirstNameAndLastName(String first, String lastName);  
 
}
