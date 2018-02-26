package servlets;

import dao.DAO;
import dao.PlayerDAO;
import dao.TeamDAO;
import dao.impl.PlayerDAOImpl;
import model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/squad")
public class SquadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        DAO dao = (DAO) session.getAttribute("dao");
        PlayerDAO playerDAO = new PlayerDAOImpl(dao);
        TeamDAO teamDAO = (TeamDAO) session.getAttribute("teamDao");
        List<Player> players = null;
        String teamName = "";
        if (req.getParameter("teamId")!=null){
            int teamId = Integer.parseInt(req.getParameter("teamId"));
            players = playerDAO.getPlayers(teamId);
            teamName= teamDAO.getTeam(teamId).getTeamName();
        }
        session.setAttribute("teamName", teamName);
        session.setAttribute("players", players);
        req.getRequestDispatcher("squad.jsp").forward(req,resp);
    }
}
