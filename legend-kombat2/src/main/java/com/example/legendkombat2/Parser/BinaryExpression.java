package com.example.legendkombat2.Parser;

public class BinaryExpression implements Expression {
    private Expression left;
    private String operator;
    private Expression right;

    // Constructor: (Expression left, String operator, Expression right)
    public BinaryExpression(Expression left, String operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public int evaluate() {
        int leftValue = left.evaluate();
        int rightValue = right.evaluate();

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
                throw new UnsupportedOperationException("Operator " + operator + " not supported.");
        }
    }
}


