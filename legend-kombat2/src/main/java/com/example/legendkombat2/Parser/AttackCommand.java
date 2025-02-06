package com.example.legendkombat2.Parser;

class AttackCommand implements Command {
    private final String direction;
    private final Expression cost;

    public AttackCommand(String direction, Expression cost) {
        this.direction = direction;
        this.cost = cost;
    }

    @Override
    public void execute() {
        System.out.println("Attack " + direction + " with cost " + cost.evaluate());
    }
}