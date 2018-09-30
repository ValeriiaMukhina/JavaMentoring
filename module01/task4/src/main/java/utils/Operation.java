package utils;

public class Operation {

    public static double binaryOperation(double num1, double num2, String operation) {
        double result = 0;
        switch (operation) {
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
            case "/": result = num1 / num2; break;
        }
        return result;
    }
}