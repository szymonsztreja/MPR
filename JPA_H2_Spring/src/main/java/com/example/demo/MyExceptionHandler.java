package com.example.demo;

import com.example.demo.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({CustomerNotFoundException.class})
    public ResponseEntity<String> handleCustomerNotFoundException(RuntimeException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({WrongRegistrationFormatException.class, EmptyMakeException.class})
    public ResponseEntity<String> handleWrongRegistrationFormat(RuntimeException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CarDoesNotExistException.class})
    public ResponseEntity<String> handleCarDoesNotExistException(RuntimeException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({CarNotFoundException.class})
    public ResponseEntity<String> handelCarNotFoundException(RuntimeException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
