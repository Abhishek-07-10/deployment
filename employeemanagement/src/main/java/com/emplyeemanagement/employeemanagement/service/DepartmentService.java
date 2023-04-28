package com.emplyeemanagement.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emplyeemanagement.employeemanagement.model.DepartmentModel;
import com.emplyeemanagement.employeemanagement.repository.DepartmentRepository;

@Service
public class DepartmentService {
    
    @Autowired
    DepartmentRepository dRepo;

    public void saveDepartment(DepartmentModel department) {
        dRepo.save(department);
    }

    
}
