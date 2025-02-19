package com.example.legendkombat2.Model;

public class StrategyResponse {
    private String message;
    private GameStatus gameStatus; // ข้อมูลสถานะเกม (ถ้าจำเป็น)

    public StrategyResponse(String message, GameStatus gameStatus) {
        this.message = message;
        this.gameStatus = gameStatus;
    }


}
