package com.example.legendkombat2.Model;

import java.util.ArrayList;
import java.util.List;

public class PlayerRequest {
    private String playerId;
    private List<String> minions; // เปลี่ยนจาก String เป็น List<String>
    private String name;

    public String getPlayerId() {

        return playerId;
    }

    public String getName() {

        return name;
    }

    public List<Minion> getMinions() {
        List<Minion> minionList = new ArrayList<>();
        for (String minionName : minions) {
            minionList.add(createMinionFromName(minionName)); // แปลง String เป็น Minion ก่อน return
        }
        return minionList;
    }

    private Minion createMinionFromName(String name) {
        switch (name.toLowerCase()) {
            case "warrior": return new Warrior();
            case "mage": return new Mage();
            case "tank": return new Tank();
            default: throw new IllegalArgumentException("Invalid minion name: " + name);
        }
    }
}


