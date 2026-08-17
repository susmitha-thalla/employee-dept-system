package com.EmployeeManagement.Employee_Service.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    @Column(nullable = false)
    private String empName;

    @Column(nullable = false, unique = true)
    private String empEmail;

    private String designation;

    @Column(name = "department_id", nullable = false)
    private Long deptId;

}
