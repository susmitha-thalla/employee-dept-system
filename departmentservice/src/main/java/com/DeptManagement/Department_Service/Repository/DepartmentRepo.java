package com.DeptManagement.Department_Service.Repository;

import com.DeptManagement.Department_Service.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {

     Optional<Department> findByDepartmentCode(String departmentcode);
     boolean existsByDepartmentCode(String departmentcode);

}
