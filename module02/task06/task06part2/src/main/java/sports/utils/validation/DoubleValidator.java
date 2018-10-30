package sports.utils.validation;

/**
 * Strategy pattern used.
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class DoubleValidator implements InputValidator {

    @Override
    public boolean isValid(String data) {
        try {
            Double.parseDouble(data);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
