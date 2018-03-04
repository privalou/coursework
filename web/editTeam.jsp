<%@ page import="model.Team" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Team</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<%
    Team team = (Team) session.getAttribute("teamToEdit");
%>
<body>
<h1 class="header"><%= team.getTeamName() %>
</h1>
<div class="description">
    <form action="editTeam" method="post">
        <input id="changeName" name="teamName" type="text" value="<%= team.getTeamName() %>" class="textbox"> </br>
        <input id="chanePoints" name="teamPoint" type="text" value="<%= team.getPoints() %>" class="textbox"> </br>
        <input id="changeGF" name="teamGF" type="text" value="<%= team.getGoalsFor() %>" class="textbox"> </br>
        <input id="changeGA" name="teamGA" type="text" value="<%= team.getGoalsAgainst() %>" class="textbox"> </br>
        <input id="changePosition" name="teamPosition" type="text" value="<%= team.getCurrentStanding() %>"
               class="textbox"> </br>
        <input id="submitButton" type="submit" value="Accept" class="button"/>
        <a href="/teamList">Cancel</a>
    </form>
</div>
</body>
</html>
