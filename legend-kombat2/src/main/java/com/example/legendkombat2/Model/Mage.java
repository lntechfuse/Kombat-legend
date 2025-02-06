package com.example.legendkombat2.Model;

public class Mage implements Minion {
    private int hp = 80;
    private int atk = 70;
    private int def = 10;
    private int price = 120;
    private String type = "Mage";

    @Override
    public void attack(Minion opponent) {
        int damage = this.atk - opponent.getPrice();
        if (damage > 0) {
            opponent.getHp();  // Implement logic to decrease HP
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
}