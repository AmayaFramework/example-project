package io.github.amayaframework.example;

public class CalcData {
    private final double left;
    private final double right;
    private Operation operation;

    public CalcData() {
        left = 0;
        right = 0;
    }

    public CalcData(String left, String right, String operation) {
        this.left = Double.parseDouble(left);
        this.right = Double.parseDouble(right);
        this.operation = Operation.valueOf(operation);
    }

    public double calculate() {
        if (operation == null) {
            throw new UnsupportedOperationException();
        }
        if (operation == Operation.DIV && right == 0) {
            throw new IllegalArgumentException();
        }
        switch (operation) {
            case ADD:
                return left + right;
            case SUB:
                return left - right;
            case MUL:
                return left * right;
            case DIV:
                return left / right;
        }
        return 0;
    }

    public enum Operation {
        ADD,
        SUB,
        MUL,
        DIV
    }
}
