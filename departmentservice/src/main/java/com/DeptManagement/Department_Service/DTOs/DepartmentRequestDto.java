package com.DeptManagement.Department_Service.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DepartmentRequestDto {
    @NotBlank(message = "Department name is mana=datory")
    @Size(min=3 ,max=50 ,message="deptname should be between 3 to 50 characters")
    private String deptname;

    @Size(min=3 ,max=50 ,message="deptaddress should be between 3 to 50 characters")
    private String deptaddress;

    @NotBlank(message = "code should be notnull")
    private String deptcode;


}
