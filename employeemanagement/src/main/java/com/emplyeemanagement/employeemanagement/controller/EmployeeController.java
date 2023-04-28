package com.emplyeemanagement.employeemanagement.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emplyeemanagement.employeemanagement.model.EmployeeModel;
import com.emplyeemanagement.employeemanagement.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService eService;

    @PostMapping("/update/Employee/Id/{Id}")
    public void addEmployee(@PathVariable Integer Id, @RequestBody String employee) {
        EmployeeModel obj = setEmployee(employee, Id);
        eService.updateEmployee(obj);
    }

    
    private EmployeeModel setEmployee(String employee, Integer Id) {
        JSONObject jObj = new JSONObject(employee);
        EmployeeModel em = eService.getEmployeeById(Id);
        em.setFullName(jObj.getString("fullName"));
        em.setEmail(jObj.getString("email"));
        em.setPhNum(jObj.getString("phNum"));
        return em;
    }
}
