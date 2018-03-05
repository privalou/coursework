<%@ page import="model.Team" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Match</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<%
    List<Team> teams = (List<Team>) session.getAttribute("teams");

%>
<body>
<h1 class="header">Add match
</h1>
<div class="description">
    <form action="addMatch" method="post">
        <select class="description" name="teamSelectorHome">
            <%
                for (Team team : teams) {

            %>
            <option><%=team.getTeamName() %>
            </option>
            <%
                }
            %>
        </select>
        <select class="description" name="teamSelectorGuest">
            <%
                for (Team team : teams) {

            %>
            <option><%=team.getTeamName() %>
            </option>
            <%
                }
            %>
        </select></br>
        <input name="matchday" type="date"></br>
        <input name="stadium" type="text" placeholder="Stadium" class="textbox"> </br>
        <input name="homeTeamScore" type="number" placeholder="0" class="textbox"> </br>
        <input name="guestTeamScore" type="number" placeholder="0" class="textbox"> </br>
        <input type="submit" value="Add match" class="button"/>
        <a href="/teamList">Cancel</a>
    </form>
</div>
</body>
</html>