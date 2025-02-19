package com.example.legendkombat2.Model;

public interface Minion {

    void attack(Minion opponent);


    int getHp();


    String getType();


    int getPrice();

    String getName();


    void setDefense(int defense);


    int getDefense();


    void setStrategy(String strategy);

    // เมธอดสำหรับการดึงกลยุทธ์ (Strategy) ของ Minion
    String getStrategy();

    // เปลี่ยนจาก int เป็น void
    void setHp(int hp); // เปลี่ยนการประกาศเป็น void
}
