package com.hospital.hospital.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital.CustomException.DoctorNotFoundException;
import com.hospital.hospital.dao.DoctorRepo;
import com.hospital.hospital.model.Doctor;
import com.hospital.hospital.model.Patient;
import com.hospital.hospital.service.PatientService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("Patient")
public class PatientController {
    
    @Autowired
    DoctorRepo docRepo;

    @Autowired
    PatientService service;
    
    @PostMapping("Add/patient/Details")
    public String addPatient(@Valid @RequestBody String patient) throws DoctorNotFoundException{
        JSONObject obj = new JSONObject(patient);
        Patient patientDetails = setpatient(obj);
        service.savePat1(patientDetails);
        return "Patient Details saved";
    }

    private Patient setpatient(JSONObject obj) throws DoctorNotFoundException {
        Patient pat1 = new Patient();
        pat1.setPatientName(obj.getString("patientName"));
        pat1.setSymptoms(obj.getString("symptoms"));
        pat1.setPhoneNumber(obj.getString("phoneNumber"));
        pat1.setEmail(obj.getString("email"));
        pat1.setCity(obj.getString("city"));

        List<Doctor> list =  getSpecialist(pat1.getSymptoms(), pat1.getCity());
        if(list == null || list.size() == 0){
            throw new DoctorNotFoundException();
            // return null;
        }
        Doctor doc = docRepo.findById(list.get(0).getDocId()).get();
        pat1.setDoctor(doc);
        return pat1;
    }

    @GetMapping("/get/doctor")
    public List<Doctor> getSpecialist(String symptoms, String city){
        if(symptoms.equals("Ear pain") || symptoms.equals("Nose pain") || symptoms.equals("Tongue pain")){
            return docRepo.getBySymptomsLocation("ENT",  city);
        }else if(symptoms.equals("Arthritis") || symptoms.equals("Back pain") || symptoms.equals("Tissue injuries")){
            return docRepo.getBySymptomsLocation("Orthopedic",  city);
        }else if(symptoms.equals("Dysmenorrhea")){
            return docRepo.getBySymptomsLocation("Gynecology",  city);
        }else if(symptoms.equals("Skin infection") || (symptoms.equals("Skin burn"))){
            return docRepo.getBySymptomsLocation("Dermatology",  city);
        }
        return null;
    }

    @GetMapping("/Get/Patient")
    public List<Patient> getPatient(){
        return service.getAllPatient();
    }

    @GetMapping("/GetPatient/patId/{patId}")
    public Patient getPatientById(@PathVariable Integer patId){
        return service.getPatientById(patId);
    }


    @DeleteMapping("DeletePatient/{patId}")
    public void deletePatient(@PathVariable Integer patId){
        service.deleteById(patId);
    }

}