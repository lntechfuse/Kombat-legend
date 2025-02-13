package com.example.legendkombat2.Parser;

import java.util.*;

class BlockStatement implements Statement {
    private final List<Statement> statements;

    public BlockStatement(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public void execute() {
        for (Statement statement : statements) {
            statement.execute();
        }
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
// BlockStatement class (กลุ่มของ Statement)