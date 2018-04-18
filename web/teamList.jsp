<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Teams</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
    <link rel="stylesheet" type="text/css" href="resources/modalDialog.css">
</head>
<body>
<h1 class="header">Premier League Table</h1>
<table class="table" align="center">
    <thead>
    <td>Position</td>
    <td>Club</td>
    <td>GA</td>
    <td>GA</td>
    <td>Points</td>
    <td>Edit Team</td>
    <td>Delete Team</td>
    </thead>
    <tbody>
    <c:forEach items="${teams}" var="team">
    <tr>
        <td>${team.currentStanding}
        </td>
        <td><a href="/squad?teamId=${team.teamId}">${team.teamName}
        </a></td>
        <td>${team.goalsFor}
        </td>
        <td>${team.goalsAgainst}
        </td>
        <td>${team.points}
        </td>
        <td><a href="/editTeam?teamId=${team.teamId}">Edit</a></td>
        <td><a href="/deleteTeam?teamId=${team.teamId}">Delete</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<div class="description">
    <a href="/matches">Go to matches</a>
    <a href="#openModal">Add team</a>
</div>
</form>
<div id="openModal" class="modalDialog">
    <div>
        <a href="#close" title="Close" class="close">X</a>
        <div>
            <form action="addTeam" method="post">
                Input team name </br>
                <input name="teamName" type="text" placeholder="Team Name" class="textbox"> </br>
                Input amount of points </br>
                <input name="teamPoint" type="number" placeholder="0" class="textbox"> </br>
                Goals for </br>
                <input name="teamGF" type="number" placeholder="0" class="textbox"> </br>
                Goals against </br>
                <input name="teamGA" type="number" placeholder="0" class="textbox"> </br>
                Current position </br>
                <input name="teamPosition" type="number" placeholder="1" class="textbox"> </br>
                <input type="submit" value="Add team" class="button"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>
