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
        <input name="teamPoint" type="number" placeholder="0" class="textbox"> </br>
        <input name="teamGF" type="number" placeholder="0" class="textbox"> </br>
        <input name="teamGA" type="number" placeholder="0" class="textbox"> </br>
        <input name="teamPosition" type="number" placeholder="1" class="textbox"> </br>
        <input type="submit" value="Change" class="button"/>
        <a href="/teamList">Cancel</a>
    </form>
</div>
</body>
</html>
