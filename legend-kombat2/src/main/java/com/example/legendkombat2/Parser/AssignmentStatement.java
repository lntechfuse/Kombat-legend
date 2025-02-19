package com.example.legendkombat2.Parser;

public class AssignmentStatement implements Statement {
    private String variable;
    private Expression expression;

    public AssignmentStatement(String variable, Expression expression) {
        this.variable = variable;
        this.expression = expression;
    }

    public String getVariable() {
        return variable; // เพิ่ม getter เพื่อให้เข้าถึง variable
    }

    public Expression getExpression() {
        return expression; // เพิ่ม getter เพื่อให้เข้าถึง expression
    }

    @Override
    public void execute() {

    }
}
