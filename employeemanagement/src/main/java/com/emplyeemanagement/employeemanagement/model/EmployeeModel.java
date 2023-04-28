package com.emplyeemanagement.employeemanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee_tbl")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer Id;
    @Column(name ="name")
    private String fullName;
    private String email;
    private String phNum;
    private String salary;
    private String status;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentModel department;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private ManagerModel manager_id;
}
