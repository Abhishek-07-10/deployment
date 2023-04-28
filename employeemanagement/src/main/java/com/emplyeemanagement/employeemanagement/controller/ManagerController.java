package com.emplyeemanagement.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emplyeemanagement.employeemanagement.model.ManagerModel;
import com.emplyeemanagement.employeemanagement.service.ManagerService;

@RestController
public class ManagerController {
    
    @Autowired
    ManagerService mService;

    @PostMapping("/add/manager")
    public void addManager(@RequestBody ManagerModel manager){
        mService.saveManager(manager);
    }
}
