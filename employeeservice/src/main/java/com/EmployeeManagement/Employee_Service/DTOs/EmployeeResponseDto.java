package com.EmployeeManagement.Employee_Service.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {

    private Long empId;
    private String empName;
    private String empEmail;
    private String designation;
    private Long deptId;
}
