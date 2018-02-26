package dao;

import model.Match;

import java.sql.Date;
import java.util.List;

public interface MatchDAO {
    String MATCH_ID = "match_id";

    String HOME_TEAM_ID = "home_team_id";

    String GUEST_TEAM_ID = "guest_team_id";

    String MATCHDAY = "matchday";

    String STADIUM = "stadium";

    String HOME_TEAM_SCORE = "home_team_score";

    String GUEST_TEAM_SCORE = "guest_team_score";

    public void addMatch(Match match);

    public List<Match> getMatches();

    public List<Match> getMatches(Date matchday);

    public Match getMatch(String stadium);

    public Match getMatch(int matchId);

    public void updateMatch(Match match);

    public void deleteMatch(Match match);
}
