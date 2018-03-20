<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Teams</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<body>
<h1 class="header">Premier League Table</h1>
<table class="tableMatch" align="center">
    <thead>
    <td>Home team</td>
    <td>Guest team</td>
    <td>Matchday</td>
    <td>Stadium</td>
    <td>Home team score</td>
    <td>Guest team score</td>
    <td>Edit match</td>
    <td>Delete match</td>
    </thead>
    <tbody>
    <c:forEach items="${matches}" var="match">
    <tr>
        <td>${teamDao.getTeam(match.getHomeTeamId()).getTeamName()}
        </td>
        <td>${teamDao.getTeam(match.getGuestTeamId()).getTeamName()}</td>
        <td>${match.matchday}
        </td>
        <td>${match.stadium}
        </td>
        <td>${match.homeTeamScore}
        </td>
        <td>${match.guestTeamScore}
        </td>
        <td><a href="/editMatch?matchId=${match.matchId}">Edit</a></td>
        <td><a href="/deleteMatch?matchId=${match.matchId}">Delete</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<div class="description">
    <a href="/addMatch">Add match</a>
    <a href="/teamList">Cancel</a>
</div>
</form>
</body>
</html>