package model;

public class Team {
    private int teamId;
    private String teamName;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private int currentStanding;

    public Team() {
    }

    public Team(String teamName, int points, int goalsFor, int goalsAgainst, int currentStanding) {
        this.teamName = teamName;
        this.points = points;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.currentStanding = currentStanding;
    }

    public Team(int teamId, String teamName, int points, int goalsFor, int goalsAgainst, int currentStanding) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.points = points;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.currentStanding = currentStanding;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getCurrentStanding() {
        return currentStanding;
    }

    public void setCurrentStanding(int currentStanding) {
        this.currentStanding = currentStanding;
    }
}
