package servlets.teams;

import dao.TeamDAO;
import model.Team;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteTeam")
public class DeleteTeamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        TeamDAO teamDAO = (TeamDAO) session.getAttribute("teamDao");
        if (req.getParameter("teamId") != null) {
            int teamId = Integer.parseInt(req.getParameter("teamId"));
            teamDAO.deleteTeam(teamId);
        }
        resp.sendRedirect("teamList");
    }
}
