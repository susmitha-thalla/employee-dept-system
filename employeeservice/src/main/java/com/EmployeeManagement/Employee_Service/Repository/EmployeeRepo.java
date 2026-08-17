package com.EmployeeManagement.Employee_Service.Repository;

import com.EmployeeManagement.Employee_Service.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmpEmail(String empEmail);

    boolean existsByEmpEmail(String empEmail);

    List<Employee> findByDeptId(Long deptId);
}
