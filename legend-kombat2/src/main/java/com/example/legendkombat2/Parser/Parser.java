package com.example.legendkombat2.Parser;
public class Parser implements Parserr {
    private Tokenizer tokenizer;
    private LexicalToken currentToken;

    public Parser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
        this.currentToken = tokenizer.nextToken();
    }

    @Override
    public Expression parse() {
        return expression();
    }

    private Expression expression() {
        Expression left = term();
        while (currentToken.getType() == LexicalToken.Type.OPERATOR &&
                (currentToken.getValue().equals("+") || currentToken.getValue().equals("-"))) {
            String operator = currentToken.getValue();
            consume(LexicalToken.Type.OPERATOR);
            Expression right = term();
            left = new BinaryExpression(left, operator, right);
        }
        return left;
    }

    private Expression term() {
        Expression left = factor();
        while (currentToken.getType() == LexicalToken.Type.OPERATOR &&
                (currentToken.getValue().equals("*") || currentToken.getValue().equals("/"))) {
            String operator = currentToken.getValue();
            consume(LexicalToken.Type.OPERATOR);
            Expression right = factor();
            left = new BinaryExpression(left, operator, right);
        }
        return left;
    }

    private Expression factor() {
        if (currentToken.getType() == LexicalToken.Type.NUMBER) {
            int value = Integer.parseInt(currentToken.getValue());
            consume(LexicalToken.Type.NUMBER);
            return new NumberExpression(value);
        } else if (currentToken.getType() == LexicalToken.Type.LEFT_PAREN) {
            consume(LexicalToken.Type.LEFT_PAREN);
            Expression expr = expression();
            consume(LexicalToken.Type.RIGHT_PAREN);
            return expr;
        } else {
            throw new RuntimeException("Unexpected token: " + currentToken.getValue());
        }
    }

    private void consume(LexicalToken.Type type) {
        if (currentToken.getType() == type) {
            currentToken = tokenizer.nextToken();
        } else {
            throw new RuntimeException("Expected " + type + " but found " + currentToken.getType());
        }
    }
}