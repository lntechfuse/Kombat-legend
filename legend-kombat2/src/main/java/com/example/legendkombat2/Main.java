package com.example.legendkombat2;

import java.util.Scanner;

public class Main {
    private static final Map gameMap = new MapImpl();
    private static final Player player1 = new Playerlmpl("Player 1", 1000, 5);
    private static final Player player2 = new Playerlmpl("Player 2", 1000, 5);
    private static final JsonParser jsonParser = new JsonParserImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Legend Kombat!");

        // Loop ให้ผู้เล่นผลัดกันซื้อพื้นที่, ซื้อมินเนียน และทำการรบ
        boolean gameRunning = true;
        while (gameRunning) {
            System.out.println("\nPlayer 1's turn:");
            playerTurn(player1, scanner);

            System.out.println("\nPlayer 2's turn:");
            playerTurn(player2, scanner);

            // ต่อสู้
            System.out.println("\nStarting the battle...");
            String battleResult = battle();
            System.out.println(battleResult);

            // สอบถามผู้เล่นว่าต้องการเล่นต่อหรือไม่
            System.out.println("Do you want to continue? (yes/no): ");
            String continueGame = scanner.nextLine().trim().toLowerCase();
            gameRunning = continueGame.equals("yes");
        }

        scanner.close();
        System.out.println("Thanks for playing!");
    }

    // ฟังก์ชันที่ให้ผู้เล่นเลือกซื้อพื้นที่หรือมินเนียน
    private static void playerTurn(Player player, Scanner scanner) {
        System.out.println(player.getName() + ", choose an action:");
        System.out.println("1. Buy area");
        System.out.println("2. Buy minion");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                buyArea(player, scanner);
                break;
            case 2:
                buyMinion(player, scanner);
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    // ฟังก์ชันซื้อพื้นที่
    private static void buyArea(Player player, Scanner scanner) {
        System.out.println("Enter row (0-7): ");
        int row = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter column (0-7): ");
        int col = Integer.parseInt(scanner.nextLine());

        Hextile tileToBuy = gameMap.getTile(row, col);
        player.buyArea(tileToBuy);

        System.out.println(player.getName() + " bought area at (" + row + "," + col + ")");
    }

    // ฟังก์ชันซื้อมินเนียน
    private static void buyMinion(Player player, Scanner scanner) {
        System.out.println("Enter minion type (warrior, tank, mage): ");
        String minionType = scanner.nextLine().trim().toLowerCase();

        Minion minion = createMinionFromType(minionType);

        if (minion != null) {
            player.buyMinion(minion);
            System.out.println(player.getName() + " bought a " + minionType);
        } else {
            System.out.println("Invalid minion type.");
        }
    }

    // ฟังก์ชันสร้างมินเนียนจากประเภทที่ผู้เล่นเลือก
    private static Minion createMinionFromType(String type) {
        switch (type) {
            case "warrior":
                return new Warrior();
            case "tank":
                return new Tank();
            case "mage":
                return new Mage();
            default:
                return null;
        }
    }

    // ฟังก์ชันที่ทำการรบระหว่างมินเนียนของผู้เล่น
    private static String battle() {
        StringBuilder battleLog = new StringBuilder();

        for (int i = 0; i < player1.getMinions().size(); i++) {
            if (i < player2.getMinions().size()) {
                Minion m1 = player1.getMinions().get(i);
                Minion m2 = player2.getMinions().get(i);

                battleLog.append(m1.getType()).append(" vs ").append(m2.getType()).append("\n");
                m1.attack(m2);

                if (m2.getHp() > 0) {
                    m2.attack(m1);
                }
            }
        }

        gameMap.updateMap();
        return battleLog.toString();
    }
}
