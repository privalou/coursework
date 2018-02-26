package dao.impl;

import dao.DAO;
import dao.TeamDAO;
import model.Team;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDAOImpl implements TeamDAO {
    private DAO dao;

    public TeamDAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void addTeam(Team team) {
        String query = "INSERT INTO team (team_name, points, goals_for, goals_against, current_standing) " +
                "(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(query);
            preparedStatement.setString(1, team.getTeamName());
            preparedStatement.setInt(2, team.getPoints());
            preparedStatement.setInt(3, team.getGoalsFor());
            preparedStatement.setInt(4, team.getCurrentStanding());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection();
        }
    }

    @Override
    public List<Team> getTeams() {
        String query = "SELECT * FROM TEAM ORDER BY current_standing";
        List<Team> teams = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(TEAM_ID);
                String teamName = resultSet.getString(TEAM_NAME);
                int points = resultSet.getInt(POINTS);
                int goalsFor = resultSet.getInt(GOALS_FOR);
                int goalsAgainst = resultSet.getInt(GOALS_AGAINST);
                int standing = resultSet.getInt(CURRENT_STANDING);
                Team team = new Team(id, teamName, points, goalsFor, goalsAgainst, standing);
                teams.add(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection();
        }
        return teams;
    }

    @Override
    public Team getTeam(String teamName) {
        String query = "SELECT * FROM team WHERE team_name = ?";
        Team team = null;
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(query);
            preparedStatement.setString(1, teamName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(TEAM_ID);
                String name = resultSet.getString(TEAM_NAME);
                int points = resultSet.getInt(POINTS);
                int goalsFor = resultSet.getInt(GOALS_FOR);
                int goalsAgainst = resultSet.getInt(GOALS_AGAINST);
                int standing = resultSet.getInt(CURRENT_STANDING);
                team = new Team(id, name, points, goalsFor, goalsAgainst, standing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection();
        }
        return team;
    }

    @Override
    public Team getTeam(int teamId) {
        String query = "SELECT * FROM team WHERE team_id = ?";
        Team team = null;
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, teamId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(TEAM_ID);
                String name = resultSet.getString(TEAM_NAME);
                int points = resultSet.getInt(POINTS);
                int goalsFor = resultSet.getInt(GOALS_FOR);
                int goalsAgainst = resultSet.getInt(GOALS_AGAINST);
                int standing = resultSet.getInt(CURRENT_STANDING);
                team = new Team(id, name, points, goalsFor, goalsAgainst, standing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection();
        }
        return team;
    }

    @Override
    public void updateTeam(Team team) {
        String query = "UPDATE TEAM SET TEAM_NAME = ? , POINTS = ? , GOALS_FOR = ? , GOALS_AGAINST = ?, " +
                "CURRENT_STANDING = ? " +
                "WHERE TEAM_ID = ?";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(query);
            preparedStatement.setString(1, team.getTeamName());
            preparedStatement.setInt(2, team.getPoints());
            preparedStatement.setInt(3, team.getGoalsFor());
            preparedStatement.setInt(4, team.getGoalsAgainst());
            preparedStatement.setInt(5, team.getCurrentStanding());
            preparedStatement.setInt(6, team.getTeamId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection();
        }
    }

    @Override
    public void deleteTeam(Team team) {
        String query = "DELETE team WHERE TEAM_ID = ?";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, team.getTeamId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection();
        }
    }
}
