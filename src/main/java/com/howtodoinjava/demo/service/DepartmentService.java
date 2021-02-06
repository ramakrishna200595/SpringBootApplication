package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.Department;
import com.howtodoinjava.demo.repository.DepartmentRepository;
 
@Service
public class DepartmentService {
     
    @Autowired
    DepartmentRepository repository;
     
    public List<Department> getAllDepartments()
    {
        List<Department> deptList = repository.findAll();
         
        if(deptList.size() > 0) {
            return deptList;
        } else {
            return new ArrayList<Department>();
        }
    }
     
    public Department getDepartmentById(Long id) throws RecordNotFoundException
    {
        Optional<Department> department = repository.findById(id);
         
        if(department.isPresent()) {
            return department.get();
        } else {
            throw new RecordNotFoundException("No department record exist for given id");
        }
    }
     
    public Department createOrUpdateDepartment(Department entity) throws RecordNotFoundException
    {
        Optional<Department> department = repository.findById(entity.getId());
         
        if(department.isPresent())
        {
        	Department newEntity = department.get();
        	newEntity.setDeptName(entity.getDeptName());
        	newEntity.setEmployees(entity.getEmployees());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
    public void deleteDepartmentById(Long id) throws RecordNotFoundException
    {
        Optional<Department> department = repository.findById(id);
         
        if(department.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No department record exist for given id");
        }
    }
}