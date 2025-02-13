package com.example.legendkombat2.Map;

import com.example.legendkombat2.Model.Minion;

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

    // ฟังก์ชันวาง Minion บนสนาม
    public boolean placeMinion(int x, int y, Minion minion) {
        // ตรวจสอบว่าช่องนั้นว่างอยู่หรือไม่
        if (grid[x][y].getMinion() == null) { // ใช้ getMinion() เพื่อตรวจสอบ
            grid[x][y].setMinion(minion); // วาง Minion ลงในช่อง
            return true;
        }
        return false; // หากช่องนั้นมี Minion อยู่แล้ว จะไม่สามารถวางใหม่ได้
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
