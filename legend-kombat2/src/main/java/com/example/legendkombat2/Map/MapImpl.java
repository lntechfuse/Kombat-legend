package com.example.legendkombat2.Map;

import com.example.legendkombat2.Model.Minion;
import com.example.legendkombat2.Model.Player;

public class MapImpl implements Map {
    private Hextile[][] grid;

    public MapImpl() {
        this.grid = new Hextile[8][8];
        initializeMap();
    }

    private void initializeMap() {
        // กำหนดค่าเริ่มต้นของแผนที่
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                boolean isPurchasable = (row < 2 || row > 5); // กำหนดว่าช่องนั้นสามารถซื้อได้หรือไม่
                grid[row][col] = new HexTileImpl(row, col, false, isPurchasable, 200);
            }
        }
    }

    // ฟังก์ชันวาง Minion บนสนาม
    public boolean placeMinion(int x, int y, Minion minion) {
        // ตรวจสอบว่า x และ y อยู่ในขอบเขตที่ถูกต้องหรือไม่
        if (x < 0 || x >= 8 || y < 0 || y >= 8) {
            System.out.println("Coordinates out of bounds: (" + x + ", " + y + ")");
            return false; // คืนค่า false หาก x หรือ y ออกนอกขอบเขต
        }
        // ตรวจสอบว่าช่องว่างอยู่หรือไม่
        if (!grid[x][y].isOccupied()) {
            grid[x][y].setMinion(minion);  // วาง Minion ลงในช่อง
            grid[x][y].setOccupied(true); // ทำเครื่องหมายว่าช่องนี้ถูกจับจองแล้ว
            return true;
        }
        System.out.println("Tile is already occupied at: (" + x + ", " + y + ")");
        return false; // หากช่องนั้นมี Minion อยู่แล้ว จะไม่สามารถวางใหม่ได้
    }

    @Override
    public Hextile getTile(int row, int col) {
        // ตรวจสอบว่าช่องที่ต้องการเข้าถึงอยู่ในขอบเขตหรือไม่
        if (row < 0 || row >= 8 || col < 0 || col >= 8) {
            throw new IndexOutOfBoundsException("Coordinates out of bounds: (" + row + ", " + col + ")");
        }
        return grid[row][col];
    }

    @Override
    public void updateMap() {
        // TODO: Implement map update logic
        System.out.println("Map updated."); // เพิ่มข้อความแจ้งเตือนเมื่ออัพเดทแผนที่
    }

    @Override
    public void setupFreeSpaces(Player player) {
        // กำหนดการจัดการพื้นที่ว่างสำหรับผู้เล่น
        System.out.println("Setting up free spaces for player: " + player.getPlayerId());
        // เพิ่มการดำเนินการที่เกี่ยวข้องที่นี่ เช่น การกำหนดพื้นที่ที่ว่างสำหรับผู้เล่น
    }
}
