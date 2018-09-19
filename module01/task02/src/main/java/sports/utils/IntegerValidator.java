package sports.utils;

public class IntegerValidator implements ValidateInput {
    @Override
    public boolean isValid(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}