package com.epam.training.exception;

public class ExpectedDataNotFoundException extends RuntimeException {
    public ExpectedDataNotFoundException(String message) {
        super(message);
    }
}
