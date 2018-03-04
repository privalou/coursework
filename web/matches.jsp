<%@ page import="model.Team" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Match" %>
<%@ page import="dao.TeamDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teams</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<%
    List<Match> matches = (List<Match>) session.getAttribute("matches");
    TeamDAO teamDAO = (TeamDAO) session.getAttribute("teamDao");
%>
<body>
<h1 class="header">Premier League Table</h1>
<table class="tableMatch" align="center">
    <thead>
    <td>Home team</td>
    <td>Guest team</td>
    <td>Matchday</td>
    <td>Stadium</td>
    <td>Home team score</td>
    <td>Guest team score</td>
    <td>Edit match</td>
    <td>Delete match</td>
    </thead>
    <% for (Match match :
            matches) {
    %>
    <tbody>
    <tr>
        <td><%= teamDAO.getTeam(match.getHomeTeamId()).getTeamName() %>
        </td>
        <td><%= teamDAO.getTeam(match.getGuestTeamId()).getTeamName() %></td>
        <td><%= match.getMatchday() %>
        </td>
        <td><%= match.getStadium() %>
        </td>
        <td><%= match.getHomeTeamScore() %>
        </td>
        <td><%= match.getGuestTeamScore() %>
        </td>
        <td><a href="/editMatch?matchId=<%=match.getMatchId()%>">Edit</a></td>
        <td><a href="/deleteMatch?matchId=<%=match.getMatchId()%>">Delete</a></td>
    </tr>
    </tbody>
    <% }%>
</table>
<div class="description">
    <a href="/addMatch">Add match</a>
    <a href="/teamList">Cancel</a>
</div>
</form>
</body>
</html>