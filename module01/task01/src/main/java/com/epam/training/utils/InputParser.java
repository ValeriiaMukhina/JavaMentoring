package com.epam.training.utils;

import com.epam.training.domain.Outcomes;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputParser {

    private InputParser() {
    }

    public static String parseYear(String input) {
        return isYear(input) ? input : null;
    }

    public static String parseWeek(String input) {
        return isWeek(input) ? input : null;
    }

    public static Outcomes parseOutcome(String input) {
        if (input.toLowerCase().contains("1")) {
            return Outcomes.FIRST_TEAM_WIN;
        } else if (input.toLowerCase().contains("2")) {
            return Outcomes.SECOND_TEAM_WIN;
        } else if (input.toLowerCase().contains("x")) {
            return Outcomes.DRAW;
        } else {
            System.err.println("Invalid entry found.");
            return null;
        }
    }

    public static BigDecimal parseCurrencyToBigDecimal(String input) {
        return new BigDecimal(input.replace("UAH", "").replace(" ", ""));
    }

    private static boolean isWeek(String input) {
        return input.matches("^(5[0-3]|[1-4][0-9]|[1-9])$");
    }

    public static Integer parseInteger(String input) {
        return isInteger(input) ? Integer.parseInt(input) : 0;
    }

    public static LocalDate parseLocalDate(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd.");
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(input, formatter);
        } catch (DateTimeParseException e) {
            localDate = null;
        }
        return localDate;
    }

    private static boolean isInteger(String strNum) {
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    private static boolean isYear(String input) {
        return input.matches("^\\d{4}");
    }


    public static String convertToCurrency(BigDecimal input) {
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
        formatSymbols.setGroupingSeparator(' ');
        DecimalFormat formatter = new DecimalFormat("###,###.# UAH", formatSymbols);
        formatter.setGroupingSize(3);
        return formatter.format(input);
    }

    public static String formatDoubles(double input) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(input);
    }
}