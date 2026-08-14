package com.DeptManagement.Department_Service.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleNotFound(DepartmentNotFoundException ex) {
            return  buildResponse(HttpStatus.NOT_FOUND,ex.getMessage())
    }
    @ExceptionHandler(DuplicateDepartmentCodeException.class)
    public ResponseEntity<Map<String, Object>> handleDuplicate(DuplicateDepartmentCodeException ex) {
        return buildResponse(HttpStatus.CONFLICT, ex.getMessage());
    }

    public ResponseEntity<Map<String,Object>> buildResponse(HttpStatus status,String message){
        Map<String,Object> map=new HashMap<>();
        map.put("status",status.value());
        map.put("Message",message);


    }

}
