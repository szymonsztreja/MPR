package com.example.demo.exceptions;

public class EmptyMakeException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Make cannot be null";
    }
}
