package com.example.legendkombat2.Parser;

public class WhileStatement implements Statement {
    private Expression condition;
    private Statement body;

    public WhileStatement(Expression condition, Statement body) {
        this.condition = condition;
        this.body = body;
    }

    public Statement getBody() {
        return body; // เพิ่ม getter เพื่อให้เข้าถึง body
    }

    @Override
    public void execute() {
        while (condition.evaluate() != 0) { // สมมติว่า evaluate() คืนค่า int
            body.execute();
        }
    }
}

// WhileStatement class (การวนลูป while)
