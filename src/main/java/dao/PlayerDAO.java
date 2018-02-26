package dao;

import model.Player;

import java.util.List;

public interface PlayerDAO {

    String PLAYER_ID = "player_id";

    String PLAYER_NAME = "player_name";

    String NUMBER = "number";

    String PLAYING_POSITION = "playing_position";

    String TEAM_ID = "team_id";

    public void addPlayer(Player player);

    public List<Player> getPlayers();

    public Player getPlayer(String playerName);

    public Player getPlayer(int playerId);

    public void updatePlayer(Player player);

    public void deletePlayer(Player player);
}
