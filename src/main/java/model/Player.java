package model;

public class Player {
    private int playerId;
    private String playerName;
    private int number;
    private String playerPosition;
    private int teamId;

    public Player() {
    }

    public Player(int playerId, String playerName, int number, String playerPosition, int teamId) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.number = number;
        this.playerPosition = playerPosition;
        this.teamId = teamId;
    }

    public Player(String playerName, int number, String playerPosition, int teamId) {
        this.playerName = playerName;
        this.number = number;
        this.playerPosition = playerPosition;
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

}
