package com.DeptManagement.Department_Service.Service;

import com.DeptManagement.Department_Service.DTOs.DepartmentRequestDto;
import com.DeptManagement.Department_Service.DTOs.DepartmentResponseDto;
import com.DeptManagement.Department_Service.Entity.Department;
import com.DeptManagement.Department_Service.ExceptionHandling.DepartmentNotFoundException;
import com.DeptManagement.Department_Service.ExceptionHandling.DuplicateDepartmentCodeException;
import com.DeptManagement.Department_Service.Mapper.DepartmentMapper;
import com.DeptManagement.Department_Service.Repository.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepo deptRepo;

    DepartmentMapper deptMapper;

    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto deptRequestDto) {
         log.info("Creating department with code: {}",deptRequestDto.getDeptcode());


          if(deptRepo.existsByDepartmentCode(deptRequestDto.getDeptcode())){
              throw new DuplicateDepartmentCodeException("Department with code "+deptRequestDto.getDeptcode()+" already exists");
          }

              Department department =deptMapper.toEntity(deptRequestDto);
              Department savedObject=deptRepo.save(department);

           log.info("department created successfully with id {}",savedObject.getDeptid());
              return deptMapper.toDto(savedObject);
    }



   @Override
   public  DepartmentResponseDto getDepartmentById(Long id){

        Department dept=deptRepo.findById(id).orElseThrow(()->new DepartmentNotFoundException("Department with id "+id+" not found"));
        return deptMapper.toDto(dept);
   }

   @Override
    public List<DepartmentResponseDto> getAllDepartments(){
       return deptRepo.findAll().stream().map(deptMapper::toDto).toList();
   }

   @Override
  public  DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto requestDto){
       Department dept=deptRepo.findById(id).orElseThrow(()->new DepartmentNotFoundException("Department with id "+id+" not found"));
              dept.setDeptname(requestDto.getDeptname());
              dept.setDeptaddress(requestDto.getDeptaddress());
              dept.setDeptcode(requestDto.getDeptcode());
     Department updatedDept=deptRepo.save(dept);

     log.info("Department with id {} updated successfully",id);
     return deptMapper.toDto(updatedDept);
    }


   @Override
    public void deleteDepartment(Long id){
        if(!deptRepo.existsById(id)){
             throw new DepartmentNotFoundException("Department with id "+id+" not found");
        }

     deptRepo.deleteById(id);
        log.info("Department with id {} deleted successfully",id);
   }

   @Override
   public  boolean existsById(Long id){
       return deptRepo.existsById(id);
   }
}
