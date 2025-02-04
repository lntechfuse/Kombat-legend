package com.example.legendkombat2;


public class Warrior implements Minion {
    private int hp = 100;
    private int atk = 50;
    private int def = 20;
    private int price = 100;
    private String type = "Warrior";

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
