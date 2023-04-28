package com.emplyeemanagement.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emplyeemanagement.employeemanagement.model.ManagerModel;
import com.emplyeemanagement.employeemanagement.repository.ManagerRepository;

@Service
public class ManagerService {

    @Autowired
    ManagerRepository mRepo; 
    public void saveManager(ManagerModel manager) {
      mRepo.save(manager);
    }
    
}
