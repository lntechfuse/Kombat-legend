package com.example.legendkombat2.GameController;

import com.example.legendkombat2.Map.Map;
import com.example.legendkombat2.Map.MapImpl;
import com.example.legendkombat2.Model.*;
import com.example.legendkombat2.Parser.Tokenizer;
import com.example.legendkombat2.Parser.Parser;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    private List<Player> players;
    private Map map;

    public GameController() {
        players = new ArrayList<>();
        map = new MapImpl(); // สร้างแผนที่
     }

    @PostMapping("/start-game")
    public ResponseEntity<String> startGame(@RequestBody List<PlayerRequest> playerRequests) {

        int initialBudget = 100; // เปลี่ยนตามที่ต้องการ
        int initialMinionsLeft = 3; // เปลี่ยนตามที่ต้องการ

        // รับข้อมูลผู้เล่นและเริ่มเกม
        for (PlayerRequest request : playerRequests) {
            Player player = new Playerlmpl(request.getPlayerId(), request.getName(), initialBudget, initialMinionsLeft, request.getMinions());
            players.add(player);
        }

        // สร้างพื้นที่เกม
        setupGameArea();

        return ResponseEntity.ok("Game Started Successfully");
    }

    private void setupGameArea() {
        // กำหนดพื้นที่ว่างในแผนที่
        for (Player player : players) {
            map.setupFreeSpaces(player);
        }
    }

    @PostMapping("/submit-strategy")
    public ResponseEntity<StrategyResponse> submitStrategy(@RequestBody StrategyRequest request) {
        // สร้าง Tokenizer
        Tokenizer tokenizer = new Tokenizer(request.getStrategy());

        // ส่ง Strategy ไปยัง Parser เพื่อตรวจสอบ
        Parser parser = new Parser(tokenizer);
        boolean isValid = parser.validate(request.getStrategy());

        if (!isValid) {
            return ResponseEntity.badRequest().body(new StrategyResponse("Syntax Error in Strategy", null));
        }

        // ถ้าผ่านให้ส่งข้อมูลไปยัง Game Logic
        processGameLogic(request);

        // สร้าง ResponseDTO
        StrategyResponse response = new StrategyResponse("Strategy Submitted Successfully", getGameStatus());
        return ResponseEntity.ok(response);
    }

    private void processGameLogic(StrategyRequest request) {
        // ประมวลผลเกมตาม Strategy ที่ผู้เล่นกำหนด
        Player player = findPlayerById(request.getPlayerId());
        if (player != null) {
            // ตัวอย่างการดำเนินการตามกลยุทธ์
            // ทำการประมวลผลตามที่ผู้เล่นได้กำหนดในกลยุทธ์
        }
    }

    private Player findPlayerById(String playerId) {
        for (Player player : players) {
            if (player.getPlayerId().equals(playerId)) {
                return player;
            }
        }
        return null;
    }

    private GameStatus getGameStatus() {
        // คืนค่า GameStatus ปัจจุบัน
        return new GameStatus();
    }
}
