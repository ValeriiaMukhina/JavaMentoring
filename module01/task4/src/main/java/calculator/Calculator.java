package calculator;

import domain.Expression;
import utils.ConsoleReader;
import utils.Printer;

public class Calculator {
    public static void main(String[] args) {
        Printer.printToConsole("Enter an expression: ");
        Expression expression = ConsoleReader.readExpression();

        double result = expression.calculate();
        Printer.printToConsole(String.valueOf(result));
    }
}
