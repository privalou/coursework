package dao.impl;

import dao.DAO;
import dao.MatchDAO;
import model.Match;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatchDAOImpl implements MatchDAO {
    private DAO dao;

    public MatchDAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void addMatch(Match match) {
        String query = "INSERT INTO match" +
                " (home_team_id, guest_team_id, matchday, stadium, home_team_score,guest_team_score) VALUES " +
                "(?,?,?,?,?,?)";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, match.getHomeTeamId());
            preparedStatement.setInt(2, match.getGuestTeamId());
            preparedStatement.setDate(3, match.getMatchday());
            preparedStatement.setString(4, match.getStadium());
            preparedStatement.setInt(5, match.getHomeTeamScore());
            preparedStatement.setInt(6, match.getGuestTeamScore());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Match> getMatches() {
        List<Match> matches = new ArrayList<>();
        String query = "SELECT * FROM MATCH";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int matchId = resultSet.getInt(MATCH_ID);
                int homeTeamId = resultSet.getInt(HOME_TEAM_ID);
                int guestTeamId = resultSet.getInt(GUEST_TEAM_ID);
                Date matchday = resultSet.getDate(MATCHDAY);
                String stadium = resultSet.getString(STADIUM);
                int homeTeamScore = resultSet.getInt(HOME_TEAM_SCORE);
                int guestTeamScore = resultSet.getInt(GUEST_TEAM_SCORE);
                Match match = new Match(matchId, homeTeamId, guestTeamId, matchday, stadium, homeTeamScore, guestTeamScore);
                matches.add(match);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matches;
    }

    @Override
    public List<Match> getMatches(Date matchday) {

        return null;
    }

    @Override
    public Match getMatch(String stadium) {
        return null;
    }

    @Override
    public Match getMatch(int matchId) {
        String query = "SELECT * FROM MATCH WHERE MATCH_ID = ?";
        Match match = null;
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, matchId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(MATCH_ID);
                int homeTeamId = resultSet.getInt(HOME_TEAM_ID);
                int guestTeamId = resultSet.getInt(GUEST_TEAM_ID);
                Date matchday = resultSet.getDate(MATCHDAY);
                String stadium = resultSet.getString(STADIUM);
                int homeTeamScore = resultSet.getInt(HOME_TEAM_SCORE);
                int guestTeamScore = resultSet.getInt(GUEST_TEAM_SCORE);
                match = new Match(id, homeTeamId, guestTeamId, matchday, stadium, homeTeamScore, guestTeamScore);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return match;
    }

    @Override
    public void updateMatch(Match match) {
        String query = "UPDATE MATCH SET HOME_TEAM_ID = ? , GUEST_TEAM_ID = ? , MATCHDAY = ? , STADIUM = ?, " +
                "HOME_TEAM_SCORE = ?, GUEST_TEAM_SCORE = ? " +
                "WHERE MATCH_ID = ?";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, match.getHomeTeamId());
            preparedStatement.setInt(2, match.getGuestTeamId());
            preparedStatement.setDate(3, match.getMatchday());
            preparedStatement.setString(4, match.getStadium());
            preparedStatement.setInt(5, match.getHomeTeamScore());
            preparedStatement.setInt(6, match.getGuestTeamScore());
            preparedStatement.setInt(7, match.getMatchId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMatch(Match match) {
        String query = "DELETE FROM MATCH WHERE MATCH_ID = ?";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, match.getMatchId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMatch(int matchId) {
        String query = "DELETE FROM MATCH WHERE MATCH_ID = ?";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, matchId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
