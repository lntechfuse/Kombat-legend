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
        // logic สำหรับการโจมตี
        System.out.println("Shoot " + direction + " with expression: " + expression);
    }

    // สร้าง getter method สำหรับ direction
    public String getDirection() {
        return direction;
    }

    // สร้าง getter method สำหรับ expression
    public Expression getExpression() {
        return expression;
    }
}




