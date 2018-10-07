package domain;

import utils.DataUtils;

import java.util.Arrays;

import static utils.Operation.binaryOperation;


public class Expression {

    private String[] operations;
    private double[] numbers;
    private int length;

    private Expression(double[] numbers, String[] operations, int length) {
        this.numbers = numbers;
        this.operations = operations;
        this.length = operations.length;
    }

    public Expression of (String inputExpression) {
        String[] operations = DataUtils.getOperators(inputExpression);
        double[] numbers = DataUtils.getNumbers(inputExpression);
        int length = operations.length;
        return new Expression(numbers, operations, length);
    }

    public double calculate() {
        doOperationOnNumbers("*");
        doOperationOnNumbers("/");
        doOperationOnNumbers("-");
        doOperationOnNumbers("+");
        return numbers[0];
    }

    private void doOperationOnNumbers(String operation) {
        int i = 1;
        while (i < length) {
            if (operation.equals(operations[i])) {
                numbers[i - 1] = binaryOperation(numbers[i - 1], numbers[i], operations[i]);
                shiftArraysAtIndex(i);
            } else {
                i++;
            }
        }
    }

    private void shiftArraysAtIndex(int index) {

        for (int j = index; j < length - 1; j++) {
            numbers[j] = numbers[j + 1];
            operations[j] = operations[j + 1];
        }
        length--;
    }
}