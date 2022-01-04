package com.github.romanqed.myserver;

public class Data {
    private int left;
    private int right;

    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    @Override
    public String toString() {
        return left + ":" + right;
    }
}
