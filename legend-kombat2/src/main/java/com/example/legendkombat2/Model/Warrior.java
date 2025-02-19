package com.example.legendkombat2.Model;

public class Warrior implements Minion {
    private int hp = 80;
    private int atk = 70;
    private int defense = 10;
    private int price = 120;
    private String type = "Tank";
    private String strategy;  // ประกาศตัวแปร strategy เป็นตัวแปรของคลาส

    public Warrior() {
        this.strategy = "Default Strategy";  // กำหนดค่าเริ่มต้นให้กับ strategy
    }

    @Override
    public void attack(Minion opponent) {
        int damage = this.atk - opponent.getDefense(); // ใช้ defense แทน price
        if (damage > 0) {
            opponent.setHp(opponent.getHp() - damage); // ลด HP ของฝ่ายตรงข้าม
        }
    }

    @Override
    public int getHp() {
        return hp;
    }
    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public int getDefense() {
        return this.defense;
    }

    @Override
    public String getStrategy() {
        return this.strategy;  // คืนค่าของ strategy
    }

    @Override
    public void setStrategy(String strategy) {
        this.strategy = strategy;  // กำหนดค่า strategy
    }

    @Override
    public String getName() {
        return this.type; // คืนชื่อประเภทของ Minion
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp; // กำหนด HP ของ Minion
    }
}
