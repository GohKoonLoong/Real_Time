package com.uum.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SalesExceptionHandler {

    @ExceptionHandler(value = {SalesNotFoundException.class})
    public ResponseEntity<Object> handleSalesNotFoundException(SalesNotFoundException salesNotFoundException){

        SalesException salesException = new SalesException(
                salesNotFoundException.getMessage(),
                salesNotFoundException.getCause(),
                HttpStatus.NOT_FOUND

        );
        return new ResponseEntity<>(salesException, HttpStatus.NOT_FOUND);
    }
}
