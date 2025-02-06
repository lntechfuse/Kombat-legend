package com.example.legendkombat2.Parser;

class MoveCommand implements Command {
    private final String direction;

    public MoveCommand(String direction) {
        this.direction = direction;
    }

    @Override
    public void execute() {
        System.out.println("Move " + direction);
    }
}