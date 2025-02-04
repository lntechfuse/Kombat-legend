package com.example.legendkombat2;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/game")
public class GameController {

    private final Map gameMap = new MapImpl();
    private final Player player1 = new Playerlmpl("Player 1", 1000, 5);
    private final Player player2 = new Playerlmpl("Player 2", 1000, 5);
    private final JsonParser jsonParser = new JsonParserImpl();

    @GetMapping("/buyArea/{playerId}/{row}/{col}")
    public String buyArea(@PathVariable int playerId, @PathVariable int row, @PathVariable int col) {
        Hextile tileToBuy = gameMap.getTile(row, col);
        Player player = (playerId == 1) ? player1 : player2;
        player.buyArea(tileToBuy);
        return player.getName() + " bought area at (" + row + "," + col + ")";
    }

    @PostMapping("/buyMinion/{playerId}")
    public String buyMinion(@PathVariable int playerId, @RequestBody String minionJson) {
        try {
            MinionDTO minionDTO = jsonParser.fromJson(minionJson, MinionDTO.class);
            Player player = (playerId == 1) ? player1 : player2;
            Minion minion = createMinionFromDTO(minionDTO);
            player.buyMinion(minion);
            return player.getName() + " bought a " + minion.getType();
        } catch (IOException e) {
            return "Error parsing JSON: " + e.getMessage();
        }
    }

    @GetMapping("/battle")
    public String battle() {
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

    private Minion createMinionFromDTO(MinionDTO minionDTO) {
        switch (minionDTO.getType().toLowerCase()) {
            case "warrior":
                return new Warrior();
            case "tank":
                return new Tank();
            case "mage":
                return new Mage();
            default:
                throw new IllegalArgumentException("Invalid minion type");
        }
    }
}

