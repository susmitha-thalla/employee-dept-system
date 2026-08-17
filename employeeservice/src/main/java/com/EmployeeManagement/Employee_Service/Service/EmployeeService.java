package com.EmployeeManagement.Employee_Service.Service;



import com.EmployeeManagement.Employee_Service.DTOs.EmployeeRequestDto;
import com.EmployeeManagement.Employee_Service.DTOs.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDto createEmployee(EmployeeRequestDto requestDto);
    EmployeeResponseDto getEmployeeById(Long id);
    List<EmployeeResponseDto> getAllEmployees();
    EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto requestDto);
    void deleteEmployee(Long id);
}
