<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>${teamName} squad</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>

<body>
<h1 class="header" align="center">${teamName}
</h1>
<table class="table" align="center">
    <thead>
    <td>Number</td>
    <td>Player name</td>
    <td>Player position</td>
    <td>Edit Player</td>
    <td>Delete Player</td>
    </thead>
    <tbody>
    <c:forEach items="${players}" var="player">
    <tr>
        <td>${player.number}
        </td>
        <td>${player.playerName}
        </td>
        <td>${player.playerPosition}
        </td>
        <td><a href="/editPlayer?playerId=${player.playerId}">Edit</a></td>
        <td><a href="/deletePlayer?playerId=${player.playerId}">Delete</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<div class="description">
    <a href="/addPlayer">Add player</a>
    <a href="/teamList">Cancel</a>
</div>

</body>
</html>