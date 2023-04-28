package com.emplyeemanagement.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emplyeemanagement.employeemanagement.model.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel,Integer> {
    
}
