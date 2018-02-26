package dao;

import model.Player;

import java.util.List;

public interface PlayerDAO {

    String PLAYER_ID = "player_id";

    String PLAYER_NAME = "player_name";

    String NUMBER = "number";

    String PLAYING_POSITION = "playing_position";

    String TEAM_ID = "team_id";

    void addPlayer(Player player);

    List<Player> getPlayers();

    Player getPlayer(String playerName);

    Player getPlayer(int playerId);

    void updatePlayer(Player player);

    void deletePlayer(Player player);
}
