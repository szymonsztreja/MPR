package com.example.demo.exceptions;

public class WrongRegistrationFormatException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Wrong registration format!";
    }
}
