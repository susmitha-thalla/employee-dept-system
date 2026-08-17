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
public class RegisterRequestDto {

    @NotBlank(message = "Employee name is required")
    private String empName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String empEmail;

    @NotBlank(message = "Designation is required")
    private String designation;

    @NotNull(message = "Department id is required")
    private Long deptId;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Role is required")
    private String role;
}
