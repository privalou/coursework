<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit Team</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<body>
<h1 class="header">${teamToEdit.teamName}
</h1>
<div class="description">
    <form action="editTeam" method="post">
        Name </br>
        <input id="changeName" name="teamName" type="text" value="${teamToEdit.teamName}" class="textbox"> </br>
        Points</br>
        <input id="chanePoints" name="teamPoint" type="number" value="${teamToEdit.points}" class="textbox"> </br>
        Goals for</br>
        <input id="changeGF" name="teamGF" type="number" value="${teamToEdit.goalsFor}" class="textbox"> </br>
        Goals against</br>
        <input id="changeGA" name="teamGA" type="number" value="${teamToEdit.goalsAgainst}" class="textbox"> </br>
        Current position</br>
        <input id="changePosition" name="teamPosition" type="number" value="${teamToEdit.currentStanding}"
               class="textbox"> </br>
        <input id="submitButton" type="submit" value="Accept" class="button"/>
        <a href="/teamList">Cancel</a>
    </form>
</div>
</body>
</html>
