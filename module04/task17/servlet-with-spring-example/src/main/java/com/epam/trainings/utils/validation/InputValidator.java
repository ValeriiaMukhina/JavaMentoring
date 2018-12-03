package com.epam.trainings.utils.validation;

/**
 * Strategy pattern used.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public interface InputValidator {

    /**
     * Interface to validate user input.
     *
     * @param data input to verify.
     * @return  isValid input
     */
    default boolean isValid(String data) {
        return true;
    }
    /**
     * Interface to validate user input.
     *
     * @return  String with error message
     */
    default String errorMessage() {
        return "Invalid Input";
    }
    /**
     * Interface to validate user input.
     *
     * @return  String with prompt
     */
    default String message() {
        return "Enter String";
    }
}
