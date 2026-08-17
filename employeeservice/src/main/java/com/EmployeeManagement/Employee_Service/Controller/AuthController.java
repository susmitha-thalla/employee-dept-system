package com.EmployeeManagement.Employee_Service.Controller;

import com.EmployeeManagement.Employee_Service.DTOs.LoginRequestDto;
import com.EmployeeManagement.Employee_Service.DTOs.LoginResponseDto;
import com.EmployeeManagement.Employee_Service.DTOs.RegisterRequestDto;
import com.EmployeeManagement.Employee_Service.Entity.Employee;
import com.EmployeeManagement.Employee_Service.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequestDto requestDto) {
        log.info("POST /auth/register - {}", requestDto.getEmpEmail());
        Employee saved = authService.register(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Employee registered successfully with id: " + saved.getEmpId());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto requestDto) {
        log.info("POST /auth/login - {}", requestDto.getEmpEmail());
        LoginResponseDto response = authService.login(requestDto);
        return ResponseEntity.ok(response);
    }
}