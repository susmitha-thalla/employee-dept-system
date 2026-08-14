package com.DeptManagement.Department_Service.ExceptionHandling;

import com.DeptManagement.Department_Service.DTOs.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(DepartmentNotFoundException ex) {
            return  buildResponse(HttpStatus.NOT_FOUND,ex.getMessage());
    }
    @ExceptionHandler(DuplicateDepartmentCodeException.class)
    public ResponseEntity<ErrorResponse> handleDuplicate(DuplicateDepartmentCodeException ex) {
        return buildResponse(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.put(error.getField(), error.getDefaultMessage());
        }

        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Validation failed",
                fieldErrors
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong: " + ex.getMessage());
    }



    public ResponseEntity<ErrorResponse> buildResponse(HttpStatus status,String message){

      ErrorResponse error=new ErrorResponse();
      error.setMessage(message);
      error.setStatus(status.value());
      error.setTimestamp(LocalDateTime.now());

      return  ResponseEntity.status(status).body(error);


    }

}
