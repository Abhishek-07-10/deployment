package com.hospital.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospital.dao.DoctorRepo;
import com.hospital.hospital.model.Doctor;

@Service
public class DoctorService {

    @Autowired
    DoctorRepo dRepo;
    public void deleteById(Integer docId) {
        dRepo.deleteById(docId);
    }

    public String saveDoc(Doctor doctor) {
        dRepo.save(doctor);
        return "saved";
    }
    
}
