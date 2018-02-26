package dao.impl;

import dao.DAO;
import dao.PlayerDAO;
import model.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAOImpl implements PlayerDAO {
    private DAO dao;

    public PlayerDAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void addPlayer(Player player) {
        String query = "INSERT INTO player (player_name, number, playing_position, team_id) VALUES " +
                "(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(query);
            preparedStatement.setString(1, player.getPlayerName());
            preparedStatement.setInt(2, player.getNumber());
            preparedStatement.setString(3, player.getPlayerPosition());
            preparedStatement.setInt(4, player.getTeamId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection();
        }
    }

    @Override
    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM player";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int playerId = resultSet.getInt(TEAM_ID);
                String playerName = resultSet.getString(PLAYER_NAME);
                int number = resultSet.getInt(NUMBER);
                String playingPosition = resultSet.getString(PLAYING_POSITION);
                int teamId = resultSet.getInt(TEAM_ID);
                Player player = new Player(playerId, playerName, number, playingPosition, teamId);
                players.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection();
        }
        return players;
    }

    @Override
    public Player getPlayer(String playerName) {
        Player player = null;
        String query = "SELECT * FROM player WHERE player_name = ?";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(query);
            preparedStatement.setString(1, playerName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int playerId = resultSet.getInt(PLAYER_ID);
                String name = resultSet.getString(PLAYER_NAME);
                int number = resultSet.getInt(NUMBER);
                String playingPosition = resultSet.getString(PLAYING_POSITION);
                int teamId = resultSet.getInt(TEAM_ID);
                player = new Player(playerId, name, number, playingPosition, teamId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection();
        }
        return player;
    }

    @Override
    public Player getPlayer(int playerId) {
        Player player = null;
        String query = "SELECT * FROM player WHERE player_id = ?";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, playerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(TEAM_ID);
                String playerName = resultSet.getString(PLAYER_NAME);
                int number = resultSet.getInt(NUMBER);
                String playingPosition = resultSet.getString(PLAYING_POSITION);
                int teamId = resultSet.getInt(TEAM_ID);
                player = new Player(id, playerName, number, playingPosition, teamId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection();
        }
        return player;
    }

    @Override
    public void updatePlayer(Player player) {
        String query = "UPDATE player SET player_name = ? , number = ? , playing_position = ? , team_id = ?,  " +
                "WHERE player_id = ?";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(query);
            preparedStatement.setString(1, player.getPlayerName());
            preparedStatement.setInt(2, player.getNumber());
            preparedStatement.setString(3, player.getPlayerPosition());
            preparedStatement.setInt(4, player.getTeamId());
            preparedStatement.setInt(5, player.getPlayerId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection();
        }
    }

    @Override
    public void deletePlayer(Player player) {
        String query = "DELETE player WHERE player_id = ?";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, player.getPlayerId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection();
        }
    }
}
