package sports.utils;

import sports.domain.betting.Currency;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtils {

    public static Currency getCurrency(String currency) {
        Currency answer;
            if (currency.equalsIgnoreCase("EUR")) {
                answer = Currency.EUR;
            } else if (currency.equalsIgnoreCase("HUF")) {
                answer = Currency.HUF;
            } else if (currency.equalsIgnoreCase("USD")) {
                answer = Currency.USD;
            } else {
                throw new IllegalArgumentException();
            }
        return answer;
    }

    public static LocalDate getDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }

    public static int getOption(String data) {
        if("q".equals(data)) {
            return 0;
        } else {
            return Integer.parseInt(data);
        }
    }
}