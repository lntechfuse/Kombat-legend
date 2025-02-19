package com.example.legendkombat2.Map;

import com.example.legendkombat2.Model.Minion;  // อย่าลืม import Minion

public interface Hextile {
    boolean isOccupied();

    void setOccupied(boolean occupied);

    boolean isPurchasable();

    int getPrice();

    int getRow();

    int getCol();

    // เพิ่มเมธอดสำหรับการจัดการ Minion
    Minion getMinion();     // ดึง Minion ที่อยู่ในช่อง
    void setMinion(Minion minion);   // ตั้ง Minion ในช่อง
}
