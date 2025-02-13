package com.example.legendkombat2.Map;

import com.example.legendkombat2.Model.Minion; // อย่าลืม import Minion

public class HexTileImpl implements Hextile {
    private int row;
    private int col;
    private boolean isOccupied;
    private boolean isPurchasable;
    private int price;
    private Minion minion; // ฟิลด์ใหม่สำหรับเก็บ Minion

    public HexTileImpl(int row, int col, boolean isOccupied, boolean isPurchasable, int price) {
        this.row = row;
        this.col = col;
        this.isOccupied = isOccupied;
        this.isPurchasable = isPurchasable;
        this.price = price;
        this.minion = null; // เริ่มต้นด้วยการไม่มี Minion ในช่องนี้
    }

    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    @Override
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public boolean isPurchasable() {
        return isPurchasable;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getCol() {
        return col;
    }

    // เพิ่มเมธอดสำหรับจัดการ Minion
    public Minion getMinion() {
        return minion;
    }

    public void setMinion(Minion minion) {
        this.minion = minion;
    }
}
