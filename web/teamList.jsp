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
<h1 class="header">Premier League Table</h1>
    <table class="table" align="center">
        <thead>
        <td>Position</td>
        <td>Club</td>
        <td>GA</td>
        <td>GA</td>
        <td>Points</td>
        <td>Edit Team</td>
        <td>Delete Team</td>
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
            <td><a href="/editTeam?teamId=<%=team.getTeamId()%>">Edit</a></td>
            <td><a href="/deleteTeam?teamId=<%=team.getTeamId()%>">Delete</a></td>
        </tr>
        </tbody>
        <% }%>
    </table>
    <div class="description">
        <a href="/matches">Go to matches</a>
        <a href="/addTeam">Add team</a>
    </div>
</form>
</body>
</html>
