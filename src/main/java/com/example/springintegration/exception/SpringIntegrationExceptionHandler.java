package com.example.springintegration.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SpringIntegrationExceptionHandler {

    public static final String EMPTY_ARRAY = "Input array can't be empty";

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> validationExceptionHandler(ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(EMPTY_ARRAY);
    }
}