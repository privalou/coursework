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
        Name </br>
        <input id="changeName" name="teamName" type="text" value="<%= team.getTeamName() %>" class="textbox"> </br>
        Points</br>
        <input id="chanePoints" name="teamPoint" type="number" value="<%= team.getPoints() %>" class="textbox"> </br>
        Goals for</br>
        <input id="changeGF" name="teamGF" type="number" value="<%= team.getGoalsFor() %>" class="textbox"> </br>
        Goals against</br>
        <input id="changeGA" name="teamGA" type="number" value="<%= team.getGoalsAgainst() %>" class="textbox"> </br>
        Current position</br>
        <input id="changePosition" name="teamPosition" type="number" value="<%= team.getCurrentStanding() %>"
               class="textbox"> </br>
        <input id="submitButton" type="submit" value="Accept" class="button"/>
        <a href="/matches">Cancel</a>
    </form>
</div>
</body>
</html>
