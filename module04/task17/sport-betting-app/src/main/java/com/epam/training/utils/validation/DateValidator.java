package com.epam.training.utils.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Strategy pattern used.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public class DateValidator implements InputValidator {

    @Override
    public boolean isValid(String data) {
        LocalDate localDate = null;
        boolean isValid = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            localDate = LocalDate.parse(data, formatter);
        } catch (DateTimeParseException e) {
            isValid = false;
        }
        if (localDate != null) {
            isValid = true;
        }
        return isValid;
    }

    @Override
    public String errorMessage() {
        return "Please enter a valid date.";
    }

    @Override
    public String message() {
        return "Enter a date in format :'yyyy-MM-dd'";
    }
}
