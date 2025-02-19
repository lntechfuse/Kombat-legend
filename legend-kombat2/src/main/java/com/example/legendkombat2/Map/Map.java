package com.example.legendkombat2.Map;
import com.example.legendkombat2.Model.*;

import com.example.legendkombat2.Model.Player;

public interface Map {
    void setupFreeSpaces(Player player);
    Hextile getTile(int row, int col);
    void updateMap();

}


