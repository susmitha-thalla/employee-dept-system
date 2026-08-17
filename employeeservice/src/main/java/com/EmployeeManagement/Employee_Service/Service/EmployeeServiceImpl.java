package com.EmployeeManagement.Employee_Service.Service;
import com.EmployeeManagement.Employee_Service.DTOs.EmployeeRequestDto;
import com.EmployeeManagement.Employee_Service.DTOs.EmployeeResponseDto;
import com.EmployeeManagement.Employee_Service.Entity.Employee;
import com.EmployeeManagement.Employee_Service.Exceptions.DuplicateEmployeeEmailException;
import com.EmployeeManagement.Employee_Service.Exceptions.EmployeeNotFoundException;
import com.EmployeeManagement.Employee_Service.Mapper.EmployeeMapper;
import com.EmployeeManagement.Employee_Service.Repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final EmployeeMapper employeeMapper;


    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto requestDto) {
        log.info("Creating employee with email: {}", requestDto.getEmpEmail());

        if (employeeRepo.existsByEmpEmail(requestDto.getEmpEmail())) {
            throw new DuplicateEmployeeEmailException(
                    "Employee already exists with email: " + requestDto.getEmpEmail());
        }

        Employee employee = employeeMapper.toEntity(requestDto);
        Employee saved = employeeRepo.save(employee);
        log.info("Employee created with id: {}", saved.getEmpId());
        return employeeMapper.toResponseDto(saved);
    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        return employeeMapper.toResponseDto(employee);
    }

    @Override
    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeRepo.findAll().stream().map(employeeMapper::toResponseDto).toList();
    }

    @Override
    public EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto requestDto) {
        Employee existing = employeeRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

        existing.setEmpName(requestDto.getEmpName());
        existing.setEmpEmail(requestDto.getEmpEmail());
        existing.setDesignation(requestDto.getDesignation());
        existing.setDeptId(requestDto.getDeptId());

        Employee updated = employeeRepo.save(existing);
        log.info("Employee updated with id: {}", updated.getEmpId());
        return employeeMapper.toResponseDto(updated);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepo.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        employeeRepo.deleteById(id);
        log.info("Employee deleted with id: {}", id);
    }
}