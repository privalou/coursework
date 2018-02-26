<%@ page import="model.Team" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Team</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<%
    Team team = (Team) request.getAttribute("teamToEdit");
%>
<body>
<h1 class="header" align="center"><%= team.getTeamName() %>
</h1>
</body>
</html>
