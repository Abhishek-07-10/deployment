package com.hospital.hospital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient_tbl")
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 255, message = "Name must be between 3 and 255 characters")
    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "symptoms")
    private String symptoms;

    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 10, max = 20, message = "Phone number should be of 10 characters")
    @Column(name = "patient_no")
    private String phoneNumber;

    @NotBlank(message = "City is mandatory")
    @Size(max = 20, message = "City must be maximum 20 characters")
    @Column(name = "City")
    private String city;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Column(name = "Email")
    private String email;

    @JoinColumn(name = "doctor_id")
    @ManyToOne
    private Doctor doctor;

}

