package com.example.legendkombat2.Model;

import com.example.legendkombat2.Map.Hextile;
import com.example.legendkombat2.Map.HexTileImpl;
import java.util.ArrayList;
import java.util.List;

public class Playerlmpl implements Player {
    private String name;
    private int budget;
    private int minionsLeft;
    private List<Minion> minions;
    private List<Hextile> ownedTiles;

    public Playerlmpl(String name, int budget, int minionsLeft) {
        this.name = name;
        this.budget = budget;
        this.minionsLeft = minionsLeft;
        this.minions = new ArrayList<>();
        this.ownedTiles = new ArrayList<>();
    }

    @Override
    public void buyArea(Hextile tile) {
        if (tile.isPurchasable() && !tile.isOccupied()) {
            if (this.budget >= tile.getPrice()) {
                this.budget -= tile.getPrice();
                tile.setOccupied(true);
                this.ownedTiles.add(tile);
            }
        }
    }

    @Override
    public void buyMinion(Minion minion) {
        if (this.budget >= minion.getPrice()) {
            this.budget -= minion.getPrice();
            this.minions.add(minion);
            this.minionsLeft--;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Minion> getMinions() {
        return minions;
    }
}
