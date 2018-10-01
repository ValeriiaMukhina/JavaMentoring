package utils;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class DataUtils {

    public static double[] convertToDouble(String[] numbers) {
        double[] numbersConverted = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersConverted[i] = Double.valueOf(numbers[i]);
        }
        return numbersConverted;
    }

    public static String[] getOperators(String input) {
        return input.split("[0-9]+");
    }

    public static double[] getNumbers(String input) {
        return convertToDouble(input.split("[" + Pattern.quote("+-*/") + "]"));
    }

    public static String formatDouble(double number) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(number);
    }
}
