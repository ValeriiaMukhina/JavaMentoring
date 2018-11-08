package com.epam.training.exercise1.exceptions;

public class WrongCoordinateException extends RuntimeException {

    public WrongCoordinateException(String message, Throwable cause) {
        super(message, cause);
    }
}
