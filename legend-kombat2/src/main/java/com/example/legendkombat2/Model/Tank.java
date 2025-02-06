package com.example.legendkombat2.Model;

public class Tank implements Minion {
    private int hp = 200;
    private int atk = 30;
    private int def = 60;
    private int price = 150;
    private String type = "Tank";

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

