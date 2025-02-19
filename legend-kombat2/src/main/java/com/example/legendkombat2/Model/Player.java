package com.example.legendkombat2.Model;

import java.util.List;
import com.example.legendkombat2.Map.Hextile;

public interface Player {
    void buyArea(Hextile tile);

    void buyMinion(Minion minion);

    String getName();

    List<Minion> getMinions();

    int getBudget();

    void setBudget(int budget);

    int getMinionsLeft();

    void setMinionsLeft(int minionsLeft);

    List<Hextile> getOwnedTiles();

    String getPlayerId();

    void setupFreeSpaces(Player player);
}
