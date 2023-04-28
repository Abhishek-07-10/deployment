package com.emplyeemanagement.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emplyeemanagement.employeemanagement.model.DepartmentModel;
import com.emplyeemanagement.employeemanagement.service.DepartmentService;

@RestController
public class DepartmentController {
    
    @Autowired
    DepartmentService dService;

    @PostMapping("/add/department")
    public void addDepartment(@RequestBody DepartmentModel department){
        dService.saveDepartment(department);
    }
}
