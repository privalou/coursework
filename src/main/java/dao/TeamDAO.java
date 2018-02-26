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

    public void addTeam(Team team);

    public List<Team> getTeams();

    public Team getTeam(String teamName);

    public Team getTeam(int teamId);

    public void updateTeam(Team team);

    public void deleteTeam(Team team);
}
