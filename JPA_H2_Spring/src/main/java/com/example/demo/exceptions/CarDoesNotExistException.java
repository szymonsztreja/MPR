package com.example.demo.exceptions;

public class CarDoesNotExistException extends RuntimeException {
    @Override
    public String getMessage(){
        return "Car id does not exist";
    }
}
