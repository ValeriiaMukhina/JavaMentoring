package calculator;

import domain.Expression;
import utils.ConsoleReader;
import utils.Printer;

public class Calculator {
    public static void main(String[] args) {
        Printer.printToConsole("Enter an expression: ");
        Expression expression = ConsoleReader.readExpression();

        int result = expression.calculate();
        Printer.printToConsole(String.valueOf(result));
    }

    private static int[] convert(String[] numbers) {
        int[] numbersConverted = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersConverted[i] = Integer.valueOf(numbers[i]);
        }
        return numbersConverted;
    }


}
