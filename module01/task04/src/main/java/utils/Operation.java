package utils;

import java.util.function.DoubleBinaryOperator;

public enum Operation implements DoubleBinaryOperator {
    PLUS("+", (l, r) -> l + r),
    MINUS("-", (l, r) -> l - r),
    MULTIPLY("*", (l, r) -> l * r),
    DIVIDE("/", (l, r) -> l / r);

    private final String symbol;
    private final DoubleBinaryOperator binaryOperator;

    private Operation(final String symbol, final DoubleBinaryOperator binaryOperator) {
        this.symbol = symbol;
        this.binaryOperator = binaryOperator;
    }

    Operation(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public double applyAsDouble(final double left, final double right) {
        return binaryOperator.applyAsDouble(left, right);
    }

    public static double binaryOperation(double num1, double num2, Operation operation) {
        double result;
        switch (operation) {
            case PLUS : result = PLUS.applyAsDouble(num1, num2); break;
            case MINUS: result = MINUS.applyAsDouble(num1, num2); break;
            case MULTIPLY: result =  MULTIPLY.applyAsDouble(num1, num2); ; break;
            case DIVIDE: result = DIVIDE.applyAsDouble(num1, num2); ; break;
            default:
                throw new UnsupportedOperationException("Not implemented: " + operation);
        }
        return result;
    }
}