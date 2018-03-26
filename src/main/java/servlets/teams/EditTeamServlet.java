package servlets.teams;

import dao.TeamDAO;
import dao.impl.DAOPostgres;
import dao.impl.TeamDAOImpl;
import model.Team;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editTeam")
public class EditTeamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeamDAO teamDAO = new TeamDAOImpl(DAOPostgres.getInstance());
        Team team = null;
        if (req.getParameter("teamId") != null) {
            int teamId = Integer.parseInt(req.getParameter("teamId"));
            team = teamDAO.getTeam(teamId);
        }
        req.getSession().setAttribute("teamToEdit", team);
        req.getRequestDispatcher("editTeam.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teamName;
        int teamPoints;
        int teamGF;
        int teamGA;
        int teamPosition;
        if (req.getParameter("teamName") != null &&
                req.getParameter("teamPoint") != null &&
                req.getParameter("teamGF") != null &&
                req.getParameter("teamGA") != null &&
                req.getParameter("teamPosition") != null) {
            teamName = req.getParameter("teamName");
            teamPoints = Integer.parseInt(req.getParameter("teamPoint"));
            teamGF = Integer.parseInt(req.getParameter("teamGF"));
            teamGA = Integer.parseInt(req.getParameter("teamGA"));
            teamPosition = Integer.parseInt(req.getParameter("teamPosition"));
            TeamDAO teamDAO = new TeamDAOImpl(DAOPostgres.getInstance());
            Team team = (Team) req.getSession().getAttribute("teamToEdit");
            team.setTeamName(teamName);
            team.setPoints(teamPoints);
            team.setGoalsFor(teamGF);
            team.setGoalsAgainst(teamGA);
            team.setCurrentStanding(teamPosition);
            teamDAO.updateTeam(team);
            resp.sendRedirect("/teamList");
        }
    }
}
