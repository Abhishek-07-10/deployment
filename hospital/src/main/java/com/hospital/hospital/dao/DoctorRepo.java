package com.hospital.hospital.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hospital.hospital.model.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer>{

    @Query(value = "select * from doc_tbl where (doc_spec=:spec and city = :city)", nativeQuery = true)
    public List<Doctor> getBySymptomsLocation(String spec, String city);
    
}
