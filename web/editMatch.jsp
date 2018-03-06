<%@ page import="model.Player" %>
<%@ page import="model.Team" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Match" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit match</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<%
    List<Team> teams = (List<Team>) session.getAttribute("teams");
    Match match = (Match) session.getAttribute("matchToEdit");
    Team homeTeam = (Team) session.getAttribute("homeTeam");
    Team guestTeam = (Team) session.getAttribute("guestTeam");
%>
<body>
<h1 class="header">Add Team
</h1>
<div class="description">
    <form action="editMatch" method="post">
        Select home and guest teams </br>
        <select class="description" name="teamSelectorHome">
            <option><%=homeTeam.getTeamName()%>
            </option>
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
            <option><%=guestTeam.getTeamName()%>
            </option>
            <%
                for (Team team : teams) {

            %>
            <option><%=team.getTeamName() %>
            </option>
            <%
                }
            %>
        </select></br>
        Matchday </br>
        <input name="matchday" type="date"></br>
        Stadium </br>
        <input name="stadium" type="text" value="<%=match.getStadium()%>" class="textbox"> </br>
        Home team score </br>
        <input name="homeTeamScore" type="number" value="<%=match.getHomeTeamScore()%>" class="textbox"> </br>
        Guest team score </br>
        <input name="guestTeamScore" type="number" value="<%=match.getGuestTeamScore()%>" class=" textbox"> </br>
        <input type="submit" value="Edit match" class="button"/>
        <a href="/matches">Cancel</a>
    </form>
</div>
</body>
</html>
