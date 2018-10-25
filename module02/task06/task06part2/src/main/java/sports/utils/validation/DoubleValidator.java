package sports.utils.validation;

public class DoubleValidator implements InputValidator {

    @Override
    public boolean isValid(String data) {
        double val;
        try {
            val = Double.parseDouble(data);
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