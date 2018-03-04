<%@ page import="model.Player" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<%
    List<Player> players = (List<Player>) session.getAttribute("players");
    String teamName = (String) session.getAttribute("teamName");
%>
<body>
<h1 class="header"н align="center"><%= teamName %>
</h1>
<table class="table" align="center">
    <thead>
    <td>Number</td>
    <td>Player name</td>
    <td>Player position</td>
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
    </tr>
    </tbody>
    <% }%>

</table>
</body>
</html>