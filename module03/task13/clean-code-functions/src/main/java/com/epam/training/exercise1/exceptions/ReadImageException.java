package com.epam.training.exercise1.exceptions;

public class ReadImageException extends RuntimeException {

    public ReadImageException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReadImageException(String message) {
        super(message);
    }
}
