package com.example.legendkombat2.Parser;

class ArithExprFactory {
    public static Expression createExpression(LexicalToken token) {
        if (token.getType() == LexicalToken.Type.NUMBER) {
            return new NumberExpression(Integer.parseInt(token.getValue()));
        }
        return null;
    }

    public static Expression createBinaryExpression(Expression left, String operator, Expression right) {
        return new BinaryExpression(left, operator, right); // ลำดับ arguments ตรงกับ constructor ของ BinaryExpression
    }

}