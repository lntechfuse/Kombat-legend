package com.example.legendkombat2.Model;

import com.example.legendkombat2.Map.Hextile;
import java.util.ArrayList;
import java.util.List;

public class Playerlmpl implements Player {  // เปลี่ยนชื่อคลาสให้ตรงตามมาตรฐาน
    private String name;
    private int budget;
    private int minionsLeft;
    private List<Minion> minions;
    private List<Hextile> ownedTiles;
    private String playerId;

    // คอนสตรัคเตอร์ที่รองรับ Minions
    public Playerlmpl(String playerId, String name, int budget, int minionsLeft, List<Minion> minions) {
        this.playerId = playerId; // ตั้งค่า playerId
        this.name = name;
        this.budget = budget;
        this.minionsLeft = minionsLeft;
        this.minions = (minions != null) ? minions : new ArrayList<>();  // ป้องกัน NullPointerException
        this.ownedTiles = new ArrayList<>();
    }

    // คอนสตรัคเตอร์เดิม (รองรับการสร้าง Player โดยไม่มี Minion)
    public Playerlmpl(String playerId, String name, int budget, int minionsLeft) {
        this(playerId, name, budget, minionsLeft, new ArrayList<>());
    }

    @Override
    public void buyArea(Hextile tile) {
        if (tile == null) {
            System.out.println(" ไม่สามารถซื้อพื้นที่ที่เป็น null ได้!");
            return;
        }
        if (!tile.isPurchasable() || tile.isOccupied()) {
            System.out.println(" พื้นที่นี้ไม่สามารถซื้อได้!");
            return;
        }
        if (this.budget < tile.getPrice()) {
            System.out.println(" เงินไม่พอสำหรับซื้อพื้นที่นี้!");
            return;
        }

        this.budget -= tile.getPrice();
        tile.setOccupied(true);
        this.ownedTiles.add(tile);
        System.out.println(" ซื้อพื้นที่สำเร็จ: " + tile);
    }

    @Override
    public void buyMinion(Minion minion) {
        if (minion == null) {
            System.out.println(" ไม่สามารถซื้อ Minion ที่เป็น null ได้!");
            return;
        }
        if (this.minionsLeft <= 0) {
            System.out.println("⚠ ไม่สามารถซื้อ Minion ได้อีกแล้ว!");
            return;
        }
        if (this.budget < minion.getPrice()) {
            System.out.println(" เงินไม่พอสำหรับซื้อมินเนี่ยน!");
            return;
        }

        this.budget -= minion.getPrice();
        this.minions.add(minion);
        this.minionsLeft = Math.max(0, this.minionsLeft - 1);  // ป้องกันค่าติดลบ
        System.out.println(" ซื้อมินเนี่ยนสำเร็จ: " + minion.getName());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Minion> getMinions() {
        return minions;
    }

    @Override
    public int getBudget() {
        return budget;
    }

    @Override
    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public int getMinionsLeft() {
        return minionsLeft;
    }

    @Override
    public void setMinionsLeft(int minionsLeft) {
        this.minionsLeft = minionsLeft;
    }

    @Override
    public List<Hextile> getOwnedTiles() {
        return ownedTiles;
    }

    @Override
    public String getPlayerId() {
        return playerId; // คืนค่า playerId
    }

    @Override
    public void setupFreeSpaces(Player player){
        System.out.println("ตั้งค่าพื้นที่ว่างสำหรับผู้เล่น: " + player.getPlayerId());
    }

    // เพิ่มฟังก์ชันคืนค่ารายละเอียดของ Minions ทั้งหมด
    public List<String> getMinionDetails() {
        List<String> details = new ArrayList<>();
        for (Minion minion : minions) {
            details.add(minion.getName() + " (ราคา: " + minion.getPrice() + ")");
        }
        return details;
    }

    // ฟังก์ชันคืนค่าคะแนนหรืองบประมาณเมื่อผู้เล่นชนะ
    public void updateBudgetOnWin(int amount) {
        this.budget += amount;
        System.out.println(" งบประมาณเพิ่มขึ้น: " + amount + " ตอนนี้คุณมี: " + budget);
    }

    // ฟังก์ชันรีเซ็ต Minions ที่เหลืออยู่
    public void resetMinions() {
        this.minions.clear();
        this.minionsLeft = 3; // รีเซ็ต Minions Left กลับมาเป็นค่าเริ่มต้น
        System.out.println(" รีเซ็ต Minions เสร็จเรียบร้อย");
    }

    // เพิ่ม toString() เพื่อ debug ได้ง่ายขึ้น
    @Override
    public String toString() {
        return "PlayerImpl{" +
                "name='" + name + '\'' +
                ", budget=" + budget +
                ", minionsLeft=" + minionsLeft +
                ", minions=" + minions +
                ", ownedTiles=" + ownedTiles +
                ", playerId='" + playerId + '\'' +
                '}';
    }
}
