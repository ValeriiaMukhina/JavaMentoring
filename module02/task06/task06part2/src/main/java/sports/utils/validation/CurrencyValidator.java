package sports.utils.validation;

public class CurrencyValidator implements InputValidator {

    @Override
    public boolean isValid(String data) {
        return data.equalsIgnoreCase("EUR")
                || data.equalsIgnoreCase("HUF") ||
                data.equalsIgnoreCase("USD");
    }

    @Override
    public String errorMessage() {
        return "Please enter EUR/HUF/USD value.";
    }

    @Override
    public String message() {
        return "Enter currency in format EUR/HUF/USD";
    }
}
