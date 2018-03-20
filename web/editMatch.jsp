<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit match</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<body>
<h1 class="header">Add Team
</h1>
<div class="description">
    <form action="editMatch" method="post">
        Select home and guest teams </br>
        <select class="description" name="teamSelectorHome">
            <option>${homeTeam.teamName}
            </option>
            <c:forEach items="${teams}" var="team">
            <option>${team.teamName}
            </option>
            </c:forEach>
        </select>
        <select class="description" name="teamSelectorGuest">
            <option>${guestTeam.teamName}
            </option>
            <c:forEach items="${teams}" var="team">
                <option>${team.teamName}
                </option>
            </c:forEach>
        </select></br>
        Matchday </br>
        <input name="matchday" type="date" value="${matchToEdit.matchday}"></br>
        Stadium </br>
        <input name="stadium" type="text" value="${matchToEdit.stadium}" class="textbox"> </br>
        Home team score </br>
        <input name="homeTeamScore" type="number" value="${matchToEdit.homeTeamScore}" class="textbox"> </br>
        Guest team score </br>
        <input name="guestTeamScore" type="number" value="${matchToEdit.guestTeamScore}" class=" textbox"> </br>
        <input type="submit" value="Edit match" class="button"/>
        <a href="/matches">Cancel</a>
    </form>
</div>
</body>
</html>
