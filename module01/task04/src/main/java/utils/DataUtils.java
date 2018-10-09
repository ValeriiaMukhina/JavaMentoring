package utils;

import java.text.DecimalFormat;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class DataUtils {

    public static double[] convertToDouble(String[] numbers) {
        return Stream.of(numbers).mapToDouble(Double::parseDouble).toArray();
    }

    public static String[] getOperators(String input) {
        return input.split("[0-9]+");
    }

    public static double[] getNumbers(String input) {
       // input.split("[" + Pattern.quote(Operation.values().) + "]"))
        return convertToDouble(input.split("[" + Pattern.quote("+-*/") + "]"));
    }

    public static String formatDouble(double number) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(number);
    }
}
