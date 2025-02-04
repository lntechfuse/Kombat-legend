package com.example.legendkombat2;

public interface Hextile {
    boolean isOccupied();

    void setOccupied(boolean occupied);

    boolean isPurchasable();

    int getPrice();

    int getRow();

    int getCol();
}
