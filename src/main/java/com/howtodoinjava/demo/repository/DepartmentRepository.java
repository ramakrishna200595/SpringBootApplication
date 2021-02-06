package com.howtodoinjava.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.demo.model.Department;
 
@Repository
public interface DepartmentRepository
        extends JpaRepository<Department, Long> {
 
}
