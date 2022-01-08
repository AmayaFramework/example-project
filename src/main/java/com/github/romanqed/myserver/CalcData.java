package com.github.romanqed.myserver;

public class CalcData {
    private double left;
    private double right;
    private Operation operation;

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
