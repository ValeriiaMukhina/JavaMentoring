package domain;

import utils.DataUtils;
import utils.Operation;

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

    public static Expression of(String inputExpression) {
        String[] operations = DataUtils.getOperators(inputExpression);
        double[] numbers = DataUtils.getNumbers(inputExpression);
        int length = operations.length;
        return new Expression(numbers, operations, length);
    }

    public double calculate() {
        doOperationOnNumbers(Operation.MULTIPLY);
        doOperationOnNumbers(Operation.DIVIDE);
        doOperationOnNumbers(Operation.MINUS);
        doOperationOnNumbers(Operation.PLUS);
        return numbers[0];
    }

    private void doOperationOnNumbers(Operation operation) {
        int i = 1;
        while (i < length) {
            if (operation.getOperationSign().equals(operations[i])) {
                numbers[i - 1] = binaryOperation(numbers[i - 1], numbers[i], operations[i]);
                shiftArraysAtIndex(i);
            } else {
                i++;
            }
        }
    }

    private void shiftArraysAtIndex(int index) {
        System.arraycopy(numbers, index + 1, numbers, index, length - index - 1);
        System.arraycopy(operations, index + 1, operations, index, length - index - 1);
        length--;
    }
}