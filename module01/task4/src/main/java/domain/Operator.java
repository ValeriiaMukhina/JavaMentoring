package domain;

public enum Operator {
    PLUS("+"), MINUS("-"), MULT("*"), DIV("/");

    private final String label;

    private Operator(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}