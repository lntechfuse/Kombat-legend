package com.example.legendkombat2.Parser;

// MoveCommand class implements ActionCommand
public class MoveCommand implements Command {
    private String direction;

    public MoveCommand(String direction) {

        this.direction = direction;
    }

    @Override
    public void execute() {
        // logic สำหรับการเคลื่อนที่
        System.out.println("Move " + direction);
    }

    // สร้าง getter method สำหรับ direction
    public String getDirection() {

        return direction;
    }
}
