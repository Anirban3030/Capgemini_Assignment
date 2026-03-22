package com.capgemini.emsOnetoOnemap.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handles validation errors (@Valid failures)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> fieldExceptionHandler(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();
        exception.getFieldErrors()
                .forEach(fieldError -> errorMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return errorMap;
    }

    // Handles employee not found
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public Map<String, String> employeeNotFoundHandler(com.capgemini.emsOnetoOnemap.exception.EmployeeNotFoundException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", exception.getMessage());
        return errorMap;
    }

}