package com.example.legendkombat2.Model;

public class StrategyRequest {
    private String playerId;
    private String minionName;
    private String strategy;
    private String defense;

    // Constructor
    public StrategyRequest(String playerId, String minionName, String strategy, String defense) {
        this.playerId = playerId;
        this.minionName = minionName;
        this.strategy = strategy;
        this.defense = defense;
    }


    public String getPlayerId() {
        return playerId;
    }

    public String getMinionName() {
        return minionName;
    }

    public String getStrategy() {
        return strategy;
    }

    public String getDefense() {
        return defense;
    }

    // Setters
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public void setMinionName(String minionName) {
        this.minionName = minionName;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }
}
