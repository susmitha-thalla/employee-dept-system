package com.DeptManagement.Department_Service.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponseDto {

    private Long deptid;
    private String deptname;
    private String deptcode;
    private String deptaddress;
}
