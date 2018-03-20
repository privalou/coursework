<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Player</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<body>
<h1 class="header">Add player
</h1>
<div class="description">
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
        <a href="/teamList">Cancel</a>
    </form>
</div>
</body>
</html>
