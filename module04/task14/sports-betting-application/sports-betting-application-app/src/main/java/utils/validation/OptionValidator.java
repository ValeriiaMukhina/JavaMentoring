package utils.validation;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Strategy pattern used.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
@Component
@Lazy
public class OptionValidator implements InputValidator {

    @Autowired private MessageSource messageSource;

    private int optionMaxValue;


    public void setOptionMaxValue(int optionMaxValue) {
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
        return messageSource.getMessage("validation.optionError", new Object[]{optionMaxValue},
                Locale.getDefault());
    }

    @Override
    public String message() {
        return messageSource.getMessage("validation.optionMessage", new Object[]{optionMaxValue},
                Locale.getDefault());
    }
}
