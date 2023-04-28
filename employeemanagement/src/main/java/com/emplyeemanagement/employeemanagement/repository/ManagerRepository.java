package com.emplyeemanagement.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emplyeemanagement.employeemanagement.model.ManagerModel;

public interface ManagerRepository extends JpaRepository<ManagerModel,Integer> {
    
}
