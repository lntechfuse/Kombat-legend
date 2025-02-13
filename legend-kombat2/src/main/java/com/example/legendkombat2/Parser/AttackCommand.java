package com.example.legendkombat2.Parser;

// AttackCommand class implements ActionCommand
public class AttackCommand implements Command {
    private String direction;
    private Expression expression;

    public AttackCommand(String direction, Expression expression) {
        this.direction = direction;
        this.expression = expression;
    }

    @Override
    public void execute() {
        System.out.println("Attacking in direction: " + direction + " with expression value: " + expression);
    }
}