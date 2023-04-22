package com.hospital.hospital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.hospital.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer> {
    
}
