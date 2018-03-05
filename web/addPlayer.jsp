<%@ page import="model.Team" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Player</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<%
    List<Team> teams = (List<Team>) session.getAttribute("teams");

%>
<body>
<h1 class="header">Add player
</h1>
<div class="description">
    <form action="addPlayer" method="post">
        <input name="playerName" type="text" placeholder="Player name" class="textbox"> </br>
        <input name="number" type="number" placeholder="1" class="textbox"> </br>
        <input name="playingPosition" type="text" placeholder="Playing position" class="textbox"> </br>
        <select class="description" name="teamSelector">
            <%
                for (Team team : teams) {

            %>
            <option><%=team.getTeamName() %>
            </option>
            <%
                }
            %>
        </select>
        <input type="submit" value="Add player" class="button"/>
        <a href="/teamList">Cancel</a>
    </form>
</div>
</body>
</html>
