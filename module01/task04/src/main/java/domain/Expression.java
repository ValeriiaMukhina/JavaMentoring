package domain;

import utils.DataUtils;

import static utils.Operation.binaryOperation;


public class Expression {

    private String[] operations;
    private double[] numbers;
    private int length;

    public Expression(String inputExpression) {
        this.operations = DataUtils.getOperators(inputExpression);
        this.numbers = DataUtils.getNumbers(inputExpression);
        this.length = operations.length;
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