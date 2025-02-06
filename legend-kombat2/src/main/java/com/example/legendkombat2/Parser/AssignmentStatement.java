package com.example.legendkombat2.Parser;

class AssignmentStatement implements Command {
    private final String variable;
    private final Expression expression;

    public AssignmentStatement(String variable, Expression expression) {
        this.variable = variable;
        this.expression = expression;
    }

    @Override
    public void execute() {
        System.out.println(variable + " = " + expression.evaluate());
    }
}