package com.example.legendkombat2.Parser;

class IfStatement implements Statement {
    private final Expression condition;
    private final Statement thenStatement;
    private final Statement elseStatement;

    public IfStatement(Expression condition, Statement thenStatement, Statement elseStatement) {
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
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
