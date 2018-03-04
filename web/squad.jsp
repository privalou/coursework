<%@ page import="model.Player" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    List<Player> players = (List<Player>) session.getAttribute("players");
    String teamName = (String) session.getAttribute("teamName");
%>
<head>
    <title><%=teamName%> squad</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>

<body>
<h1 class="header" align="center"><%= teamName %>
</h1>
<table class="table" align="center">
    <thead>
    <td>Number</td>
    <td>Player name</td>
    <td>Player position</td>
    <td>Edit Player</td>
    <td>Delete Player</td>
    </thead>
    <% for (Player player :
            players) {
    %>
    <tbody>
    <tr>
        <td><%= player.getNumber() %>
        </td>
        <td><%= player.getPlayerName() %>
        </td>
        <td><%= player.getPlayerPosition() %>
        </td>
        <td><a href="/editPlayer?playerId=<%=player.getPlayerId()%>">Edit</a></td>
        <td><a href="/deletePlayer?playerId=<%=player.getPlayerId()%>">Delete</a></td>
    </tr>
    </tbody>
    <% }%>
</table>
<div class="description">
    <a href="/addPlayer">Add player</a>
    <a href="/teamList">Cancel</a>
</div>

</body>
</html>