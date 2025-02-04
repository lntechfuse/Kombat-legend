package com.example.legendkombat2;

import java.util.List;

public interface Player {
    void buyArea(Hextile tile);

    void buyMinion(Minion minion);

    String getName();

    List<Minion> getMinions();
}
