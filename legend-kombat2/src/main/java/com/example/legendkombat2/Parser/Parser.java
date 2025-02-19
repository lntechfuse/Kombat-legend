package com.example.legendkombat2.Parser;

import java.util.*;

public class Parser {
    private Tokenizer tokenizer;
    private LexicalToken currentToken;

    public Parser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
        this.currentToken = tokenizer.nextToken();
    }

    public Statement parse() {

        return statement();
    }

    public boolean validate(String strategy) {
        // ตรวจสอบ Syntax ของ Strategy ที่ส่งมา
        // หากผ่านให้คืนค่า true
        // หากไม่ผ่านให้คืนค่า false
        return true; // ตัวอย่างให้ผ่านทุกอย่าง
    }

    private Statement statement() {
        if (currentToken.getType() == LexicalToken.Type.IDENTIFIER) {
            return assignmentStatement(); // คืนค่า AssignmentStatement ซึ่งเป็น Statement
        } else if (currentToken.getValue().equals("if")) {
            return ifStatement(); // คืนค่า IfStatement ซึ่งเป็น Statement
        } else if (currentToken.getValue().equals("while")) {
            return whileStatement(); // คืนค่า WhileStatement ซึ่งเป็น Statement
        } else if (currentToken.getValue().equals("{")) {
            return blockStatement(); // คืนค่า BlockStatement ซึ่งเป็น Statement
        } else if (currentToken.getValue().equals("done") || currentToken.getValue().equals("move") || currentToken.getValue().equals("shoot")) {
            return actionCommand(); // คืนค่า Command ซึ่งเป็น Statement
        } else {
            throw new RuntimeException("Unexpected token: " + currentToken.getValue());
        }
    }


    private Statement actionCommand() {
        String command = currentToken.getValue();
        consume(LexicalToken.Type.KEYWORD); // 'done' or 'move' or 'shoot'
        if (command.equals("move")) {
            String direction = currentToken.getValue();
            consume(LexicalToken.Type.KEYWORD); // Direction (e.g., "up", "down", etc.)
            return new MoveCommand(direction);
        } else if (command.equals("shoot")) {
            String direction = currentToken.getValue();
            consume(LexicalToken.Type.KEYWORD); // Direction (e.g., "up", "down", etc.)
            Expression expression = expression();
            return new AttackCommand(direction, expression);
        } else if (command.equals("done")) {
            return new ActionCommand();
        } else {
            throw new RuntimeException("Unexpected command: " + command);
        }
    }


    private AssignmentStatement assignmentStatement() {
        String identifier = currentToken.getValue();
        consume(LexicalToken.Type.IDENTIFIER);
        consume(LexicalToken.Type.OPERATOR); // Expect '='
        Expression expression = expression();
        return new AssignmentStatement(identifier, expression);
    }

    private Expression expression() {
        Expression left = term();
        while (currentToken.getType() == LexicalToken.Type.OPERATOR && (currentToken.getValue().equals("+") || currentToken.getValue().equals("-"))) {
            String operator = currentToken.getValue();
            consume(LexicalToken.Type.OPERATOR);
            Expression right = term();
            left = new BinaryExpression(left, operator, right);
        }
        return left;
    }

    private Expression term() {
        Expression left = factor();
        while (currentToken.getType() == LexicalToken.Type.OPERATOR && (currentToken.getValue().equals("*") || currentToken.getValue().equals("/"))) {
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
        } else if (currentToken.getValue().equals("(")) {
            consume(LexicalToken.Type.LEFT_PAREN);
            Expression expr = expression();
            consume(LexicalToken.Type.RIGHT_PAREN);
            return expr;
        } else {
            throw new RuntimeException("Unexpected token: " + currentToken.getValue());
        }
    }

    private IfStatement ifStatement() {
        consume(LexicalToken.Type.KEYWORD); // 'if'
        consume(LexicalToken.Type.LEFT_PAREN);
        Expression condition = expression();
        consume(LexicalToken.Type.RIGHT_PAREN);
        consume(LexicalToken.Type.KEYWORD); // 'then'
        Statement thenStatement = statement();
        consume(LexicalToken.Type.KEYWORD); // 'else'
        Statement elseStatement = statement();
        return new IfStatement(condition, thenStatement, elseStatement);
    }

    private WhileStatement whileStatement() {
        consume(LexicalToken.Type.KEYWORD); // 'while'
        consume(LexicalToken.Type.LEFT_PAREN);
        Expression condition = expression();
        consume(LexicalToken.Type.RIGHT_PAREN);
        Statement body = statement();
        return new WhileStatement(condition, body);
    }

    private BlockStatement blockStatement() {
        consume(LexicalToken.Type.LEFT_BRACE);
        List<Statement> statements = new ArrayList<>();
        while (currentToken.getType() != LexicalToken.Type.RIGHT_BRACE) {
            statements.add(statement());
        }
        consume(LexicalToken.Type.RIGHT_BRACE);
        return new BlockStatement(statements);
    }


    private void consume(LexicalToken.Type type) {
        if (currentToken.getType() == type) {
            currentToken = tokenizer.nextToken();
        } else {
            throw new RuntimeException("Expected " + type + " but found " + currentToken.getType());
        }
    }
}

