package dao;

import model.Match;

import java.util.Date;
import java.util.List;

public interface MatchDAO {
    public void addMatch(Match match);

    public List<Match> getMatches();

    public List<Match> getMatches(Date matchday);

    public Match getMatch(String stadium);

    public Match getMatch(int matchId);

    public void updateMatch(Match match);

    public void deleteMatch(Match match);
}
