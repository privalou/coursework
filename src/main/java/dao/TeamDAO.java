package dao;

import model.Team;

import java.util.List;

public interface TeamDAO {
    String TEAM_ID = "team_id";

    String TEAM_NAME = "team_name";

    String POINTS = "points";

    String GOALS_FOR = "goals_for";

    String GOALS_AGAINST = "goals_against";

    String CURRENT_STANDING = "current_standing";

    void addTeam(Team team);

    List<Team> getTeams();

    Team getTeam(String teamName);

    Team getTeam(int teamId);

    void updateTeam(Team team);

    void deleteTeam(Team team);

    void deleteTeam(int teamId);
}
