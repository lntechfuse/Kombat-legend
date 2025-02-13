package com.example.legendkombat2.Parser;

class StatementFactory {
    public static Statement createStatement(String type, String variable, Expression expression) {
        switch (type) {
            case "Assignment":
                return new AssignmentStatement(variable, expression);
            case "Move":
                return new MoveCommand(variable);
            case "Attack":
                return new AttackCommand(variable, expression);
            default:
                throw new IllegalArgumentException("Unknown statement type: " + type);
        }
    }
}
