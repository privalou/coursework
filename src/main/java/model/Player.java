package model;

public class Player {
    private int playerId;
    private String playerName;
    private int number;
    private String playerPosition;
    private Team team;

    public Player() {
    }

    public Player(String playerName, int number, String playerPosition, Team team) {
        this.playerName = playerName;
        this.number = number;
        this.playerPosition = playerPosition;
        this.team = team;
    }

    public int getPlayerId() {
        return playerId;
    }

    public Player(int playerId, String playerName, int number, String playerPosition, Team team) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.number = number;
        this.playerPosition = playerPosition;
        this.team = team;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
