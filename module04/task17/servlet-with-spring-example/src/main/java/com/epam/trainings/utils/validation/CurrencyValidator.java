package com.epam.trainings.utils.validation;

/**
 * Strategy pattern used.
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class CurrencyValidator implements InputValidator {

    @Override
    public boolean isValid(String data) {
        return "EUR".equalsIgnoreCase(data)
                || "HUF".equalsIgnoreCase(data)
                || "USD".equalsIgnoreCase(data);
    }

    @Override
    public String errorMessage() {
        return "Please enter EUR/HUF/USD value.";
    }

    @Override
    public String message() {
        return "Enter currency in format EUR/HUF/USD";
    }
}
