package com.example.legendkombat2.Model;

public interface Minion {
    // เมธอดสำหรับการโจมตีฝ่ายตรงข้าม
    void attack(Minion opponent);

    // เมธอดสำหรับการดึงค่าพลังชีวิต (HP) ของ Minion
    int getHp();

    // เมธอดสำหรับการดึงประเภทของ Minion (เช่น นักรบ, นักเวท)
    String getType();

    // เมธอดสำหรับการดึงราคา (cost) ของ Minion
    int getPrice();

    // เมธอดสำหรับการตั้งค่าระดับการป้องกัน (Defense) ของ Minion
    void setDefense(int defense);

    // เมธอดสำหรับการดึงระดับการป้องกัน (Defense) ของ Minion
    int getDefense();

    // เมธอดสำหรับการตั้งค่ากลยุทธ์ (Strategy) ของ Minion
    void setStrategy(String strategy);

    // เมธอดสำหรับการดึงกลยุทธ์ (Strategy) ของ Minion
    String getStrategy();
}
