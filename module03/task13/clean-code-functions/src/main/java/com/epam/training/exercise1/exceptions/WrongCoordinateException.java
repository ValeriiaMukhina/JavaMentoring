package com.epam.training.exercise1.exceptions;
/**
 * Exception.
 *
 * @author Valeriia Biruk
 */
public class WrongCoordinateException extends RuntimeException {

    public WrongCoordinateException(String message) {
        super(message);
    }
}
