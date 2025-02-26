
import java.util.List;

enum GameMode {
    PLAYER_VS_PLAYER,
    PLAYER_VS_COM,
    COM_VS_COM
}

class GameModeState {
    private GameMode selectedMode;

    public void selectMode(GameMode mode) {
        this.selectedMode = mode;
    }

    public boolean isModeSelected() {
        return selectedMode != null;
    }

    public GameMode getSelectedMode() {
        return selectedMode;
    }
}

abstract class Player {
    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract void play();
    
    public String getName() {
        return name;
    }
}

abstract class GameCharacter {
    protected String identifier;

    public GameCharacter(String identifier) {
        this.identifier = identifier;
    }

    public abstract void performAction();

    public String getIdentifier() {
        return identifier;
    }
}

class RoomState {
    private String roomId;
    private List<Player> players;

    public RoomState(String roomId, List<Player> players) {
        this.roomId = roomId;
        this.players = players;
    }

    public void joinRoom(Player player) {
        players.add(player);
    }

    public boolean isRoomReady() {
        return players.size() >= 2;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getRoomId() {
        return roomId;
    }
}

class GameState {
    private List<GameCharacter> characters;
    private int turnNumber;
    private boolean isGameOver;

    public GameState(List<GameCharacter> characters) {
        this.characters = characters;
        this.turnNumber = 1;
        this.isGameOver = false;
    }

    public void nextTurn() {
        turnNumber++;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void checkGameOver() {
        if (characters.isEmpty()) {
            isGameOver = true;
        }
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public List<GameCharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(List<GameCharacter> characters) {
        this.characters = characters;
    }
}

// this is based on the second overview assignment
