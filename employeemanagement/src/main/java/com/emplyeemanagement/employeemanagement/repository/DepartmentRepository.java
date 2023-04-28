package com.emplyeemanagement.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emplyeemanagement.employeemanagement.model.DepartmentModel;

public interface DepartmentRepository extends JpaRepository<DepartmentModel,Integer> {
    
}
