package com.example.legendkombat2.Parser;

class WhileStatement implements Statement {
    private final Expression condition;
    private final Statement statement;

    public WhileStatement(Expression condition, Statement statement) {
        this.condition = condition;
        this.statement = statement;
    }

    @Override
    public void execute() {
        while (condition.evaluate() != 0) {
            statement.execute();
        }
    }
}
// WhileStatement class (การวนลูป while)