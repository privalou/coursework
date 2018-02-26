<%@ page import="model.Team" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teams</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<%
    List<Team> teams = (List<Team>) session.getAttribute("teams");
%>
<body>
<h1 class="header" align="center">Premier League Table</h1>
<table class="table" align="center">
    <thead>
    <td>Position</td>
    <td>Club</td>
    <td>GA</td>
    <td>GA</td>
    <td>Points</td>
    <td>Edit</td>
    <td>Delete</td>
    </thead>
    <% for (Team team :
            teams) {
    %>
    <tbody>
    <tr>
        <td><%= team.getCurrentStanding() %>
        </td>
        <td><a href="/squad?teamId=<%=team.getTeamId()%>"><%=team.getTeamName()%>
        </a></td>
        <td><%= team.getGoalsFor() %>
        </td>
        <td><%= team.getGoalsAgainst() %>
        </td>
        <td><%= team.getPoints() %>
        </td>
        <td>Edit
        </td>
        <td>Delete</td>
    </tr>
    </tbody>
    <% }%>
</table>
</body>
</html>
