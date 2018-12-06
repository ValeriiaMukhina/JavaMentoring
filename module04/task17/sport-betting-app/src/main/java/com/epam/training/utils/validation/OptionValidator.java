package com.epam.training.utils.validation;

/**
 * Strategy pattern used.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public class OptionValidator implements InputValidator {

    private int optionMaxValue;

    public OptionValidator(int optionMaxValue) {
        this.optionMaxValue = optionMaxValue;
    }

    @Override
    public boolean isValid(String data) {
        int val;
        boolean isValid = false;
        if ("q".equals(data)) {
            isValid = true;
        }
        if(!isValid) {
            try {
                val = Integer.parseInt(data);
                isValid = val <= optionMaxValue;
            } catch (NumberFormatException e) {
                isValid = false;
            }
        }
        return isValid;
    }

    @Override
    public String errorMessage() {
        return "Please enter a valid number from 1 to " + optionMaxValue + " or q.";
    }

    @Override
    public String message() {
        return "Please enter a valid number from 1 to " + optionMaxValue + " or q.";
    }
}
