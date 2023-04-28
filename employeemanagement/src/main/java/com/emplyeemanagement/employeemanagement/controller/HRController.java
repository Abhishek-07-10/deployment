package com.emplyeemanagement.employeemanagement.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emplyeemanagement.employeemanagement.model.EmployeeModel;
import com.emplyeemanagement.employeemanagement.repository.DepartmentRepository;
import com.emplyeemanagement.employeemanagement.repository.ManagerRepository;
import com.emplyeemanagement.employeemanagement.service.EmployeeService;

@RestController
public class HRController {

    @Autowired
    EmployeeService eService;

    @Autowired
    DepartmentRepository dRepo;

    @Autowired
    ManagerRepository mRepo;

    @PostMapping("admin/add/Employee/")
    public void addEmployee(@RequestBody String employee) {
        EmployeeModel obj = setEmployee(employee);
        eService.updateEmployee(obj);
    }

    private EmployeeModel setEmployee(String employee) {
        JSONObject jObj = new JSONObject(employee);
        EmployeeModel em = new EmployeeModel();
        em.setFullName(jObj.getString("fullName"));
        em.setEmail(jObj.getString("email"));
        em.setPhNum(jObj.getString("phNum"));
        em.setSalary(jObj.getString("salary"));
        int deptId = Integer.parseInt(jObj.getString("deptId"));
        em.setDepartment(dRepo.findById(deptId).get());
        int managerId = Integer.parseInt(jObj.getString("managerId"));
        em.setManager_id(mRepo.findById(managerId).get());
        return em;
    }

    @GetMapping("admin/get/allEmployee")
    public List<EmployeeModel> getAllEmployee() {
        return eService.getAllEmployee();
    }
}
