package com.EmployeeManagement.Employee_Service.Exceptions;

public class DuplicateEmployeeEmailException extends RuntimeException{
    public DuplicateEmployeeEmailException(String message) {
        super(message);
    }
}
