package domain;

import java.util.regex.Pattern;

public class Expression {

    String[] operations;
    int[] numbers;

    public Expression(String inputExpression) {
        this.operations = inputExpression.split("[" + Pattern.quote("+-*/") + "]");
        this.numbers = convert(inputExpression.split("[0-9]+"));

    }

    private static int[] convert(String[] numbers) {
        int[] numbersConverted = new int[numbers.length];


        for (int i = 0; i < numbers.length; i++) {
            numbersConverted[i] = Integer.valueOf(numbers[i]);
        }
        return numbersConverted;
    }

    public int calculate() {
        int length = operations.length;
        int index = 1;
        while (index < length) {
            if ("*".equals(operations[index])) { // NEM!!! "*" == operations[i]
                numbers[index - 1] = numbers[index - 1] * numbers[index];
                for (int j = index; j < length - 1; j++) {
                    numbers[j] = numbers[j + 1];
                    operations[j] = operations[j + 1];
                }
                length--;
            } else if ("/".equals(operations[index])) { // NEM!!! "/" == operations[i]
                numbers[index - 1] = numbers[index - 1] / numbers[index];
                for (int j = index; j < length - 1; j++) {
                    numbers[j] = numbers[j + 1];
                    operations[j] = operations[j + 1];
                }
                length--;
            } else {
                index++;
            }
        }
        index = 1;
        while (index < length) {
            if ("+".equals(operations[index])) { // NEM!!! "+" == operations[i]
                numbers[index - 1] = numbers[index - 1] + numbers[index];
                for (int j = index; j < length - 1; j++) {
                    numbers[j] = numbers[j + 1];
                    operations[j] = operations[j + 1];
                }
                length--;
            } else if ("-".equals(operations[index])) { // NEM!!! "-" == operations[i]
                numbers[index - 1] = numbers[index - 1] - numbers[index];
                for (int j = index; j < length - 1; j++) {
                    numbers[j] = numbers[j + 1];
                    operations[j] = operations[j + 1];
                }
                length--;
            } else {
                index++;
            }
        }
        return numbers[0];
    }
}
