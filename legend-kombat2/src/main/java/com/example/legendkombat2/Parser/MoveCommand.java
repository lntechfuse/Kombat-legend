package com.example.legendkombat2.Parser;

// MoveCommand class implements ActionCommand
public class MoveCommand implements Command {
    private String direction;

    public MoveCommand(String direction) {
        this.direction = direction;
    }

    @Override
    public void execute() {
        System.out.println("Moving " + direction);
    }
}
