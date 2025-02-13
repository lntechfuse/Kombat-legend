package com.example.legendkombat2.Model;

public class StrategyFactory {
    // วิธีสร้างกลยุทธ์ตาม input
    public static Strategy createStrategy(String strategyType) {
        if (strategyType.equalsIgnoreCase("offensive")) {
            return new OffensiveStrategy();
        } else if (strategyType.equalsIgnoreCase("defensive")) {
            return new DefensiveStrategy();
        } else {
            throw new IllegalArgumentException("Invalid strategy type");
        }
    }
}
