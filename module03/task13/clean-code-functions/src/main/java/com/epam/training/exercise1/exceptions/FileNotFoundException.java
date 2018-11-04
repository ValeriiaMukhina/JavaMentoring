package com.epam.training.exercise1.exceptions;

public class FileNotFoundException extends RuntimeException {

    public FileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
