package com.example.legendkombat2.Map;

public interface Map {
    Hextile getTile(int row, int col);

    void updateMap();
}

