package utils.validation;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * Strategy pattern used.
 * @author  Valeriia Biruk
 * @version 1.0
 */
@Component
public class CurrencyValidator implements InputValidator {

    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean isValid(String data) {
        return "EUR".equalsIgnoreCase(data)
                || "HUF".equalsIgnoreCase(data)
                || "USD".equalsIgnoreCase(data);
    }

    @Override
    public String errorMessage() {
        return messageSource.getMessage("validation.currencyError", new Object[]{},
                Locale.getDefault());
    }

    @Override
    public String message() {
        return messageSource.getMessage("validation.currencyMessage", new Object[]{},
                Locale.getDefault());
    }
}
