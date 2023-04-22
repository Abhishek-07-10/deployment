package com.hospital.hospital.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="doc_tbl")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="doc_id")
    private Integer docId;


    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 255, message = "Name must be between 3 and 255 characters")
    @Column(name="doc_name")
    private String docName;

    @Column(name="doc_spec")
    private String speciality;

    @NotBlank(message = "City is mandatory")
    @Size(max = 20, message = "City must be maximum 20 characters")
    @Column(name = "City")
    private String city;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Column(name = "Email")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 10, max = 20, message = "Phone number should be of atleast 10 characters")
    @Column(name="doc_phNum")
    private String phNum;

}

