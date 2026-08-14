package com.DeptManagement.Department_Service.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptid;

    @Column(nullable = false,unique = true)
    private String deptname;

    private String deptaddress;

    @Column(nullable = false ,unique = true)
    private String deptcode;

}
