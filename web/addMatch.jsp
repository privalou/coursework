<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Match</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<body>
<h1 class="header">Add match
</h1>
<div class="description">
    <form action="addMatch" method="post">
        Select home and guest teams </br>
        <select class="description" name="teamSelectorHome">
            <c:forEach items="${teams}" var="team">
                <option>${team.teamName}
                </option>
            </c:forEach>
        </select>
        <select class="description" name="teamSelectorGuest">
            <c:forEach items="${teams}" var="team">
                <option>${team.teamName}
                </option>
            </c:forEach>
        </select></br>
        Matchday </br>
        <input name="matchday" type="date"></br>
        Stadium </br>
        <input name="stadium" type="text" placeholder="Stadium" class="textbox"> </br>
        Home team score </br>
        <input name="homeTeamScore" type="number" placeholder="0" class="textbox"> </br>
        Guest team score </br>
        <input name="guestTeamScore" type="number" placeholder="0" class="textbox"> </br>
        <input type="submit" value="Add match" class="button"/>
        <a href="/teamList">Cancel</a>
    </form>
</div>
</body>
</html>
