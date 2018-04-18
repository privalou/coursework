<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>${teamName} squad</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
    <link rel="stylesheet" type="text/css" href="resources/modalDialog.css">
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
    <a href="#openModal">Add player</a>
    <a href="/teamList">Cancel</a>
</div>
<div id="openModal" class="modalDialog">
    <div>
        <a href="#close" title="Close" class="close">X</a>
        <div>
            <form action="addPlayer" method="post">
                Name </br>
                <input name="playerName" type="text" placeholder="Player name" class="textbox"> </br>
                Number </br>
                <input name="number" type="number" placeholder="1" class="textbox"> </br>
                Position </br>
                <input name="playingPosition" type="text" placeholder="Playing position" class="textbox"> </br>
                Select team </br>
                <select class="description" name="teamSelector">
                    <c:forEach items="${teams}" var="team">
                        <option>${team.teamName}
                        </option>
                    </c:forEach>
                </select>
                <input type="submit" value="Add player" class="button"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>