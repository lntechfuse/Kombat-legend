package com.example.legendkombat2.Parser;

public class InfoExpression implements Expression {
    private String info;

    public InfoExpression(String info) {

        this.info = info;
    }

    @Override
    public String toString() {

        return info; // แสดงค่าของ InfoExpression
    }

    @Override
    public int evaluate() {
        // ตรงนี้คุณสามารถกำหนดการคำนวณหรือตรวจสอบค่าของ InfoExpression
        // ตัวอย่าง: return a hardcoded value or retrieve the value based on the info string.
        if (info.equals("ally")) {
            return 1;

        }
        return 0;

    }
}

