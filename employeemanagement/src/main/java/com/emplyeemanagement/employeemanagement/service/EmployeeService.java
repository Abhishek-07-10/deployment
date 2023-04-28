package com.emplyeemanagement.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emplyeemanagement.employeemanagement.model.EmployeeModel;
import com.emplyeemanagement.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository eRepo;

    public void updateEmployee(EmployeeModel obj) {
        eRepo.save(obj);
    }

    public EmployeeModel getEmployeeById(Integer Id) {
        return eRepo.findById(Id).get();
    }

    public List<EmployeeModel> getAllEmployee() {
        return eRepo.findAll();
    }
}
