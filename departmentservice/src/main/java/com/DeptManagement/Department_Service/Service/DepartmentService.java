package com.DeptManagement.Department_Service.Service;

import com.DeptManagement.Department_Service.DTOs.DepartmentRequestDto;
import com.DeptManagement.Department_Service.DTOs.DepartmentResponseDto;
import com.DeptManagement.Department_Service.Entity.Department;

import java.util.List;

public interface DepartmentService {
         DepartmentResponseDto createDepartment(DepartmentRequestDto deptReqDto);
         DepartmentResponseDto getDepartmentById(Long id);
         List<DepartmentResponseDto> getAllDepartments();
         DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto requestDto);
         void deleteDepartment(Long id);
         boolean existsById(Long id);  // it helps to check if the department exists before updating or deleting from eployee service


}
