package com.example.legendkombat2.Parser;

public class BinaryExpression implements Expression {
    private Expression left;
    private String operator;
    private Expression right;

    public BinaryExpression(Expression left, String operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public int evaluate() {
        int leftValue = left.evaluate();  // สมมติว่า evaluate() ของ Expression จะคืนค่า int
        int rightValue = right.evaluate(); // เช่นเดียวกัน
        switch (operator) {
            case "+":
                return leftValue + rightValue;
            case "-":
                return leftValue - rightValue;
            case "*":
                return leftValue * rightValue;
            case "/":
                return leftValue / rightValue;
            default:
                throw new RuntimeException("Unknown operator: " + operator);
        }
    }

    public String getOperator() {
        return operator;
    }
    public Expression getLeft() {
        return left;
    }
    public Expression getRight() {
        return right;
    }
}
