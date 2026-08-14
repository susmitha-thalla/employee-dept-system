package com.DeptManagement.Department_Service.ExceptionHandling;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
