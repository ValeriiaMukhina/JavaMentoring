package utils.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * Strategy pattern used.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
@Component
public class DateValidator implements InputValidator {

    @Autowired
    MessageSource messageSource;

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
        return messageSource.getMessage("validation.dateError", new Object[]{},
                Locale.getDefault());
    }

    @Override
    public String message() {
        return messageSource.getMessage("validation.dateMessage", new Object[]{},
                Locale.getDefault());
    }
}
