<%@ page import="model.Player" %>
<%@ page import="model.Team" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Player</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<%
    List<Team> teams = (List<Team>) session.getAttribute("teams");
    Player player = (Player) session.getAttribute("playerToEdit");
    Team team = (Team) session.getAttribute("playersTeam");
%>
<body>
<h1 class="header">Add Team
</h1>
<div class="description">
    <form action="editPlayer" method="post">
        <input name="playerName" type="text" value="<%=player.getPlayerName()%>" class="textbox"> </br>
        <input name="number" type="number" value="<%=player.getNumber()%>" class="textbox"> </br>
        <input name="playingPosition" type="text" value="<%=player.getPlayerPosition()%>" class="textbox"> </br>
        <select name="teamSelector" class="description">
            <option><%=team.getTeamName()%></option>
            <%
                for (Team object : teams) {
            %>
            <option><%=object.getTeamName() %>
            </option>
            <%
                }
            %>
        </select>
        <input type="submit" value="Change" class="button"/>
        <a href="/teamList">Cancel</a>
    </form>
</div>
</body>
</html>
