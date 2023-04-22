package com.hospital.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital.model.Doctor;
import com.hospital.hospital.service.DoctorService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/Hospital/Doctor")
public class DoctorController {
    
    @Autowired
    DoctorService service;
    

    @PostMapping("/addDoc")
    public String addDoctor(@Valid @RequestBody Doctor doctor){
       return service.saveDoc(doctor);
    }

    @DeleteMapping("Delete/Doctor/docId/{docId}")
    public String deleteDoc(@PathVariable Integer docId){
      service.deleteById(docId);
      return "Deleted the doctor with id =" + docId;
    }
}
