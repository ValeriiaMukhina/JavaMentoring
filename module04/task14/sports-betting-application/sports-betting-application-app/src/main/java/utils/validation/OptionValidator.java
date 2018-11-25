package utils.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Strategy pattern used.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
@Component
@Lazy
public class OptionValidator implements InputValidator {

    @Autowired
    MessageSource messageSource;

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
