<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit Player</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<body>
<h1 class="header">Add Team
</h1>
<div class="description">
    <form action="editPlayer" method="post">
        Name </br>
        <input name="playerName" type="text" value="${playerToEdit.playerName}" class="textbox"> </br>
        Number </br>
        <input name="number" type="number" value="${playerToEdit.number}" class="textbox"> </br>
        Position </br>
        <input name="playingPosition" type="text" value="${playerToEdit.playerPosition}" class="textbox"> </br>
        Select team </br>
        <select name="teamSelector" class="description">
            <option>${playersTeam.teamName}</option>
            <c:forEach items="${teams}" var="team">
            <option>${team.teamName}
            </option>
            </c:forEach>
        </select>
        <input type="submit" value="Change" class="button"/>
        <a href="/teamList">Cancel</a>
    </form>
</div>
</body>
</html>
