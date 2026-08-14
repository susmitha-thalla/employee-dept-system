package com.DeptManagement.Department_Service.Mapper;

import com.DeptManagement.Department_Service.DTOs.DepartmentRequestDto;
import com.DeptManagement.Department_Service.DTOs.DepartmentResponseDto;
import com.DeptManagement.Department_Service.Entity.Department;

public class DepartmentMapper {
    public Department toEntity(DepartmentRequestDto dto){
        Department dept=new Department();
        dept.setDeptname(dto.getDeptname());
        dept.setDeptcode(dto.getDeptcode());
        dept.setDeptaddress(dto.getDeptaddress());

        return dept;
    }

    public DepartmentResponseDto toDto(Department dept){
        DepartmentResponseDto dto=new DepartmentResponseDto();
        dto.setDeptid(dept.getDeptid());
        dto.setDeptname(dept.getDeptname());
        dto.setDeptcode(dept.getDeptcode());
        dto.setDeptaddress(dept.getDeptaddress());
        return dto;
    }
}
