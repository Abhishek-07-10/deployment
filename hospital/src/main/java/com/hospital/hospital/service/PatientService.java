package com.hospital.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospital.dao.PatientRepo;
import com.hospital.hospital.model.Patient;

@Service
public class PatientService {

    @Autowired
    PatientRepo pRepo;

    public void savePat1( Patient patient) {
        pRepo.save(patient);
    }

    public void deleteById(Integer patId) {
        pRepo.deleteById(patId);
    }

    public List<Patient> getAllPatient() {
        return pRepo.findAll();
    }

    public Patient getPatientById(Integer patId) {
        return pRepo.findById(patId).get();
    }

}
