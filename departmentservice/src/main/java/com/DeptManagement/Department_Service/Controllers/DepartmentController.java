package com.DeptManagement.Department_Service.Controllers;

import com.DeptManagement.Department_Service.DTOs.DepartmentRequestDto;
import com.DeptManagement.Department_Service.DTOs.DepartmentResponseDto;
import com.DeptManagement.Department_Service.Service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/department/v1")
@RestController
@Slf4j
@RequiredArgsConstructor
public class DepartmentController {

   private final DepartmentService departmentService;

   @PostMapping("/create")
    public ResponseEntity<DepartmentResponseDto> createDepartment(@Valid @RequestBody DepartmentRequestDto departmentRequestDto){
    log.info("Received request to create department with code: {}", departmentRequestDto.getDeptcode());
    DepartmentResponseDto returnedData = departmentService.createDepartment(departmentRequestDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(returnedData);
   }

   @GetMapping("/getdepartments/{id}")
   public ResponseEntity<DepartmentResponseDto> getDepartmentById(@PathVariable Long id) {
       log.info("GET /api/v1/departments/{}", id);
       DepartmentResponseDto department = departmentService.getDepartmentById(id);
       return ResponseEntity.ok(department);
   }
    @PutMapping("/updatedept/{id}")
    public ResponseEntity<DepartmentResponseDto> updateDepartment(@PathVariable Long id,
            @Valid @RequestBody DepartmentRequestDto requestDto) {
        log.info("received request for updating  and api is PUT /api/v1/departments/{}", id);
        DepartmentResponseDto updated = departmentService.updateDepartment(id, requestDto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/getAlldepartments")
    public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments() {
        log.info("GET /api/v1/department/getdepartments");
        List<DepartmentResponseDto> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        log.info("DELETE  /api/v1/departments/{}", id);
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> checkDepartmentExists(@PathVariable Long id) {
        boolean exists = departmentService.existsById(id);
        return ResponseEntity.ok(exists);
    }

}
