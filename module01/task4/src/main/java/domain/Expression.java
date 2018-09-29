package domain;

import utils.Printer;

import java.util.regex.Pattern;

public class Expression {

    private String[] operations;
    private int[] numbers;
    private int length;

    public Expression(String inputExpression) {
        this.operations = inputExpression.split("[" + Pattern.quote("+-*/") + "]");
        this.numbers = convert(inputExpression.split("[0-9]+"));
        this.length = operations.length;

    }

    private static int[] convert(String[] numbers) {
        int[] numbersConverted = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersConverted[i] = Integer.valueOf(numbers[i]);
        }
        return numbersConverted;
    }

    public int calculate() {
        operateWithMultiplicationAndDivision();
        operateWithAdditionAndSubstraction();
        return numbers[0];
    }

    private void operateWithAdditionAndSubstraction() {
        int index = 1;
        while (index < length) {
            if (Operator.PLUS.getLabel().equals(operations[index])) { // NEM!!! "+" == operations[i]
                numbers[index - 1] = add(numbers[index - 1], numbers[index]);
                moveArrayToTheLeft(index);

            } else if (Operator.MINUS.getLabel().equals(operations[index])) { // NEM!!! "-" == operations[i]
                numbers[index - 1] = sub(numbers[index - 1], numbers[index]);
                moveArrayToTheLeft(index);

            } else {
                index++;
            }
        }
    }

    private int operateWithMultiplicationAndDivision() {
        int index = 1;
        while (index < length) {
            if (Operator.MULT.getLabel().equals(operations[index])) { // NEM!!! "*" == operations[i]
                numbers[index - 1] = mult(numbers[index - 1], numbers[index]);
                moveArrayToTheLeft(index);

            } else if (Operator.DIV.getLabel().equals(operations[index])) { // NEM!!! "/" == operations[i]
                numbers[index - 1] = divInt(numbers[index - 1], numbers[index]);
                moveArrayToTheLeft(index);

            } else {
                index++;
            }
        }
        return length;
    }

    private void moveArrayToTheLeft(int index) {
        for (int j = index; j < length - 1; j++) {
            numbers[j] = numbers[j + 1];
            operations[j] = operations[j + 1];
        }
        length--;
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int sub(int a, int b) {
        return a - b;
    }

    // Integer divide. Return a truncated int.
    private static int divInt(int a, int b) {
        int res = 0;
        try {
            res = a / b;
        } catch (ArithmeticException e) {
            Printer.printToConsole("Cannot divide by 0!"); System.exit(0);
        }
        return res;
    }

    private int mult(int a, int b) {
        return a * b;
    }
}
