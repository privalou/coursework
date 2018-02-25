package model;

import java.util.Date;

public class Match {
    private int matchId;
    private Team homeTeam;
    private Team guestTeam;
    private Date matchday;
    private String stadium;
    private int homeTeamScore;
    private int guestTeamScote;

    public Match() {
    }

    public Match(Team homeTeam, Team guestTeam, Date matchday, String stadium, int homeTeamScore, int guestTeamScote) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.matchday = matchday;
        this.stadium = stadium;
        this.homeTeamScore = homeTeamScore;
        this.guestTeamScote = guestTeamScote;
    }

    public Match(int matchId, Team homeTeam, Team guestTeam, Date matchday, String stadium, int homeTeamScore, int guestTeamScote) {
        this.matchId = matchId;
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.matchday = matchday;
        this.stadium = stadium;
        this.homeTeamScore = homeTeamScore;
        this.guestTeamScote = guestTeamScote;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(Team guestTeam) {
        this.guestTeam = guestTeam;
    }

    public Date getMatchday() {
        return matchday;
    }

    public void setMatchday(Date matchday) {
        this.matchday = matchday;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getGuestTeamScote() {
        return guestTeamScote;
    }

    public void setGuestTeamScote(int guestTeamScote) {
        this.guestTeamScote = guestTeamScote;
    }
}
