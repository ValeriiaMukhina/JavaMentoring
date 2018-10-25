package sports.utils.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator implements InputValidator {

    @Override
    public boolean isValid(String data) {
        LocalDate localDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                localDate = LocalDate.parse(data, formatter);
            } catch (DateTimeParseException e) {
                return false;
            }
            if (localDate != null) {
                return true;
            }
        return true;
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
