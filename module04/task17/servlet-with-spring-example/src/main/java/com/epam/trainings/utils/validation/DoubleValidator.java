package com.epam.trainings.utils.validation;

/**
 * Strategy pattern used.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public class DoubleValidator implements InputValidator {

    @Override
    public boolean isValid(String data) {
        boolean isValid;
        try {
            Double.parseDouble(data);
            isValid = true;
        } catch (NumberFormatException e) {
            isValid = false;
        }
        return isValid;
    }

    @Override
    public String errorMessage() {
        return "Please enter a valid double value";
    }

    @Override
    public String message() {
        return "Enter double:";
    }
}
