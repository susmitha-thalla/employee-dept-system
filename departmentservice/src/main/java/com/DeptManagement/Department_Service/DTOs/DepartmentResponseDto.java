package com.DeptManagement.Department_Service.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponseDto {

    private Long Deptid;
    private String Deptname;
    private String Deptcode;
    private String Deptaddress;
}
