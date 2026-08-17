package com.EmployeeManagement.Employee_Service.Mapper;

import com.EmployeeManagement.Employee_Service.DTOs.EmployeeRequestDto;
import com.EmployeeManagement.Employee_Service.DTOs.EmployeeResponseDto;
import com.EmployeeManagement.Employee_Service.Entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeRequestDto dto) {
        Employee employee = new Employee();
        employee.setEmpName(dto.getEmpName());
        employee.setEmpEmail(dto.getEmpEmail());
        employee.setDesignation(dto.getDesignation());
        employee.setDeptId(dto.getDeptId());
        return employee;
    }

    public EmployeeResponseDto toResponseDto(Employee employee) {
        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setEmpId(employee.getEmpId());
        dto.setEmpName(employee.getEmpName());
        dto.setEmpEmail(employee.getEmpEmail());
        dto.setDesignation(employee.getDesignation());
        dto.setDeptId(employee.getDeptId());
        return dto;
    }
}
