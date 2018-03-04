<%@ page import="model.Team" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Team</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<body>
<h1 class="header">Add Team
</h1>
<div class="description">
    <form action="addTeam" method="post">
        <input name="teamName" type="text" placeholder="Team Name" class="textbox"> </br>
        <input name="teamPoint" type="text" placeholder="Points" class="textbox"> </br>
        <input name="teamGF" type="text" placeholder="Goals For" class="textbox"> </br>
        <input name="teamGA" type="text" placeholder="Goals Against" class="textbox"> </br>
        <input name="teamPosition" type="text" placeholder="Current Position" class="textbox"> </br>
        <input type="submit" value="Add" class="button"/>
        <a href="/teamList">Cancel</a>
    </form>
</div>
</body>
</html>
