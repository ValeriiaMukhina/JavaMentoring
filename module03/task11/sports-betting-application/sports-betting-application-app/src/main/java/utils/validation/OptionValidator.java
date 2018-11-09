package utils.validation;

/**
 * Strategy pattern used.
 * @author  Valeriia Biruk
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
            if ("q".equals(data)) {
                return true;
            }
            try {
                val = Integer.parseInt(data);
                return val <= optionMaxValue;
            } catch (NumberFormatException e) {
                return false;
            }
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
