package servlets.teams;

import dao.TeamDAO;
import dao.impl.DAOPostgres;
import dao.impl.TeamDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteTeam")
public class DeleteTeamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeamDAO teamDAO = new TeamDAOImpl(DAOPostgres.getInstance());
        if (req.getParameter("teamId") != null) {
            int teamId = Integer.parseInt(req.getParameter("teamId"));
            teamDAO.deleteTeam(teamId);
        }
        resp.sendRedirect("teamList");
    }
}
