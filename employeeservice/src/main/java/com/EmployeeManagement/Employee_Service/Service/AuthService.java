package com.EmployeeManagement.Employee_Service.Service;

import com.EmployeeManagement.Employee_Service.DTOs.LoginRequestDto;
import com.EmployeeManagement.Employee_Service.DTOs.LoginResponseDto;
import com.EmployeeManagement.Employee_Service.DTOs.RegisterRequestDto;
import com.EmployeeManagement.Employee_Service.Entity.Employee;
import com.EmployeeManagement.Employee_Service.Exceptions.DuplicateEmployeeEmailException;
import com.EmployeeManagement.Employee_Service.Repository.EmployeeRepo;
import com.EmployeeManagement.Employee_Service.Security.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final EmployeeRepo employeeRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public Employee register(RegisterRequestDto requestDto) {
        log.info("Registering employee with email: {}", requestDto.getEmpEmail());

        if (employeeRepo.existsByEmpEmail(requestDto.getEmpEmail())) {
            throw new DuplicateEmployeeEmailException(
                    "Employee already exists with email: " + requestDto.getEmpEmail());
        }

        Employee employee = new Employee();
        employee.setEmpName(requestDto.getEmpName());
        employee.setEmpEmail(requestDto.getEmpEmail());
        employee.setDesignation(requestDto.getDesignation());
        employee.setDeptId(requestDto.getDeptId());
        employee.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        employee.setRole(requestDto.getRole());

        Employee saved = employeeRepo.save(employee);
        log.info("Employee registered with id: {}", saved.getEmpId());
        return saved;
    }

    public LoginResponseDto login(LoginRequestDto requestDto) {
        Employee employee = employeeRepo.findByEmpEmail(requestDto.getEmpEmail())
                .orElseThrow(() -> new BadCredentialsException("Invalid email or password"));

        if (!passwordEncoder.matches(requestDto.getPassword(), employee.getPassword())) {
            throw new BadCredentialsException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(employee.getEmpEmail(), employee.getRole());
        log.info("Login successful for: {}", employee.getEmpEmail());

        return new LoginResponseDto(token, employee.getEmpEmail(), employee.getRole());
    }
}