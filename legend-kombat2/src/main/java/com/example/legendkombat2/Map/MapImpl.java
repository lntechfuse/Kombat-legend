package com.example.legendkombat2.Map;

public class MapImpl implements Map {
    private Hextile[][] grid;

    public MapImpl() {
        this.grid = new Hextile[8][8];
        initializeMap();
    }

    private void initializeMap() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                boolean isPurchasable = (row < 2 || row > 5);
                grid[row][col] = new HexTileImpl(row, col, false, isPurchasable, 200);
            }
        }
    }

    @Override
    public Hextile getTile(int row, int col) {
        return grid[row][col];
    }

    @Override
    public void updateMap() {
        // Implement map update logic
    }
}
