package com.DeptManagement.Department_Service.ExceptionHandling;

public class DuplicateDepartmentCodeException extends RuntimeException{
    public DuplicateDepartmentCodeException(String message) {
        super(message);
    }

}
