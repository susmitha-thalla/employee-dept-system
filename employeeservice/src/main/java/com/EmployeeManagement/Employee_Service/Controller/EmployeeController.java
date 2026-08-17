package com.EmployeeManagement.Employee_Service.Controller;

import com.EmployeeManagement.Employee_Service.DTOs.EmployeeRequestDto;
import com.EmployeeManagement.Employee_Service.DTOs.EmployeeResponseDto;
import com.EmployeeManagement.Employee_Service.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeResponseDto> createEmployee(@Valid @RequestBody EmployeeRequestDto requestDto) {
        log.info("POST /v1/employee/create");
        EmployeeResponseDto created = employeeService.createEmployee(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/getemployees/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id) {
        log.info("GET /v1/employee/getemployees/{}", id);
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/getemployees")
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
        log.info("GET /v1/employee/getemployees");
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PutMapping("/updateemp/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(
            @PathVariable Long id, @Valid @RequestBody EmployeeRequestDto requestDto) {
        log.info("PUT /v1/employee/updateemp/{}", id);
        return ResponseEntity.ok(employeeService.updateEmployee(id, requestDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        log.info("DELETE /v1/employee/delete/{}", id);
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
