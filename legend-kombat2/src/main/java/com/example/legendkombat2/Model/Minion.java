package com.example.legendkombat2.Model;

public interface Minion {
    void attack(Minion opponent);

    int getHp();

    String getType();

    int getPrice();
}