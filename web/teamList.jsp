<%@ page import="model.Team" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teams</title>
</head>
<%
    List<Team> teams = (List<Team>) session.getAttribute("teams");
%>
<body>
<h1 align="center">Premier League Table</h1>
<table border="1" align="center">
    <thead>
    <td>Position</td>
    <td>Club</td>
    <td>GA</td>
    <td>GA</td>
    <td>Points</td>
    </thead>
    <% for (Team team:
            teams) {
    %>
    <tbody>
    <tr>
        <td> <%= team.getCurrentStanding() %></td>
        <td> <%= team.getTeamName() %></td>
        <td> <%= team.getGoalsFor() %></td>
        <td> <%= team.getGoalsAgainst() %></td>
        <td> <%= team.getPoints() %></td>
    </tr>
    </tbody>
    <% }%>
</table>
</body>
</html>
