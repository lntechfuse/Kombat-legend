package com.example.legendkombat2.Parser;

class StatementFactory {
    public static Statement createStatement(String type, String variable, Expression expression) {
        if ("Assignment".equals(type)) {
            return new AssignmentStatement(variable, expression);
        } else if ("Move".equals(type)) {
            return new MoveCommand(variable);
        } else if ("Attack".equals(type)) {
            return new AttackCommand(variable, expression);
        }
        return null;
    }
}
