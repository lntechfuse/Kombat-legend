package com.example.legendkombat2.Parser;

public class IfStatement implements Statement {
    private Expression condition;
    private Statement thenStatement;
    private Statement elseStatement;

    public IfStatement(Expression condition, Statement thenStatement, Statement elseStatement) {
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    public Statement getThenStatement() {

        return thenStatement; // เพิ่ม getter เพื่อให้เข้าถึง thenStatement
    }

    public Statement getElseStatement() {

        return elseStatement; // เพิ่ม getter เพื่อให้เข้าถึง elseStatement
    }

    @Override
    public void execute() {
        if (condition.evaluate() != 0) {
            thenStatement.execute();
        } else {
            elseStatement.execute();
        }
    }
}



// IfStatement class (การใช้เงื่อนไข if)
