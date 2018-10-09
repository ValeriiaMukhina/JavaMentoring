package utils;

import java.util.function.BinaryOperator;

public enum Operation implements BinaryOperator<Double> {
    PLUS("+") {
        public Double apply(Double v1, Double v2) {
            return v1 + v2;
        }
    },
    MINUS("-") {
        public Double apply(Double v1, Double v2) {
            return v1 - v2;
        }
    },
    MULTIPLY("*") {
        public Double apply(Double v1, Double v2) {
            return v1 * v2;
        }
    },
    DIVIDE("/") {
        public Double apply(Double v1, Double v2) {
            return v1 / v2;
        }
    };

    private final String operationSign;

    Operation(String operationSign) {
        this.operationSign = operationSign;
    }

    public String getOperationSign() {
        return operationSign;
    }

    public static double binaryOperation(double num1, double num2, String operationSign) {
        double result;
            if (PLUS.operationSign.equals(operationSign)) result = PLUS.apply(num1, num2);
            else if (MINUS.operationSign.equals(operationSign)) result = MINUS.apply(num1, num2);
            else if (MULTIPLY.operationSign.equals(operationSign)) result =  MULTIPLY.apply(num1, num2);
            else if (DIVIDE.operationSign.equals(operationSign)) result = DIVIDE.apply(num1, num2);
            else throw new UnsupportedOperationException("Not implemented: " + operationSign);
        return result;
    }
}