package utils.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Strategy pattern used.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
@Component
public class DoubleValidator implements InputValidator {

    @Autowired
    private MessageSource messageSource;

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
        return messageSource.getMessage("validation.doubleError", new Object[]{},
                Locale.getDefault());
    }

    @Override
    public String message() {
        return messageSource.getMessage("validation.doubleMessage", new Object[]{},
                Locale.getDefault());
    }
}
