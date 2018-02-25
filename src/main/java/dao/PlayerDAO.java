package dao;

import model.Player;

import java.util.List;

public interface PlayerDAO {
    public void addPlayer(Player player);

    public List<Player> getPlayers();

    public Player getPlayer(String playerName);

    public Player getPlayer(int playerId);

    public void updatePlayer(Player player);

    public void deletePlayer(Player player);
}
