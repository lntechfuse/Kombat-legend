package com.example.legendkombat2;

public interface Map {
    Hextile getTile(int row, int col);

    void updateMap();
}

