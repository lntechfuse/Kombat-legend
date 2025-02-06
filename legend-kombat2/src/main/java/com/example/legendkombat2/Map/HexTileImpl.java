package com.example.legendkombat2.Map;

public class HexTileImpl implements Hextile {
    private int row;
    private int col;
    private boolean isOccupied;
    private boolean isPurchasable;
    private int price;

    public HexTileImpl(int row, int col, boolean isOccupied, boolean isPurchasable, int price) {
        this.row = row;
        this.col = col;
        this.isOccupied = isOccupied;
        this.isPurchasable = isPurchasable;
        this.price = price;
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
}