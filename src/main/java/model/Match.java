package model;


import java.sql.Date;

public class Match {
    private int matchId;
    private int homeTeamId;
    private int guestTeamId;
    private Date matchday;
    private String stadium;
    private int homeTeamScore;
    private int guestTeamScore;

    public Match() {
    }

    public Match(int homeTeamId, int guestTeamId, Date matchday, String stadium, int homeTeamScore, int guestTeamScote) {
        this.homeTeamId = homeTeamId;
        this.guestTeamId = guestTeamId;
        this.matchday = matchday;
        this.stadium = stadium;
        this.homeTeamScore = homeTeamScore;
        this.guestTeamScore = guestTeamScote;
    }

    public Match(int matchId, int homeTeamId, int guestTeamId, Date matchday, String stadium, int homeTeamScore, int guestTeamScote) {
        this.matchId = matchId;
        this.homeTeamId = homeTeamId;
        this.guestTeamId = guestTeamId;
        this.matchday = matchday;
        this.stadium = stadium;
        this.homeTeamScore = homeTeamScore;
        this.guestTeamScore = guestTeamScote;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public int getGuestTeamId() {
        return guestTeamId;
    }

    public void setGuestTeamId(int guestTeamId) {
        this.guestTeamId = guestTeamId;
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

    public int getGuestTeamScore() {
        return guestTeamScore;
    }

    public void setGuestTeamScore(int guestTeamScote) {
        this.guestTeamScore = guestTeamScote;
    }
}
