package com.example.legendkombat2.LegendKombat2Application;

import com.example.legendkombat2.Model.Player;
import com.example.legendkombat2.Model.Playerlmpl;
import com.example.legendkombat2.Map.Hextile;
import com.example.legendkombat2.Map.Map;
import com.example.legendkombat2.Map.MapImpl;
import com.example.legendkombat2.Model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior", 5, "Aggressive", 100, 20);
        Archer archer = new Archer("Archer", 3, "Defensive", 80, 25);
        Defender defender = new Defender("Defender", 10, "Tank", 150, 10);
        Mage mage = new Mage("Mage", 2, "Magic", 70, 30);
        Tank tank = new Tank("Tank", 20, "Tank", 200, 15);

        warrior.attack(archer);
        System.out.println("Archer's health: " + archer.getHealth());

        warrior.specialAbility();
        mage.specialAbility();
        tank.specialAbility();
    }
}
