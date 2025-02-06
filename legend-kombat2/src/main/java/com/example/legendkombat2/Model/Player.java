package com.example.legendkombat2.Model;

import java.util.List;
import com.example.legendkombat2.Map.Hextile;

public interface Player {
    void buyArea(Hextile tile);

    void buyMinion(Minion minion);

    String getName();

    List<Minion> getMinions();
}
