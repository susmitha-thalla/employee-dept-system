package com.EmployeeManagement.Employee_Service.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {
    @NotBlank(message = "Employee name is required")
    @Size(min = 2, max = 100, message = "Employee name must be between 2 and 100 characters")
    private String empName;

    @NotBlank(message = "Employee email is required")
    @Email(message = "Email must be valid")
    private String empEmail;

    @NotBlank(message = "Designation is required")
    private String designation;

    @NotNull(message = "Department id is required")
    private Long deptId;
}
