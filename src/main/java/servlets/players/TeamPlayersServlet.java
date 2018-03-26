package servlets.players;

import dao.PlayerDAO;
import dao.TeamDAO;
import dao.impl.DAOPostgres;
import dao.impl.PlayerDAOImpl;
import dao.impl.TeamDAOImpl;
import model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/squad")
public class TeamPlayersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlayerDAO playerDAO = new PlayerDAOImpl(DAOPostgres.getInstance());
        TeamDAO teamDAO = new TeamDAOImpl(DAOPostgres.getInstance());
        List<Player> players = null;
        String teamName = "";
        if (req.getParameter("teamId") != null) {
            int teamId = Integer.parseInt(req.getParameter("teamId"));
            players = playerDAO.getPlayers(teamId);
            teamName = teamDAO.getTeam(teamId).getTeamName();
        }
        req.setAttribute("teamName", teamName);
        req.setAttribute("players", players);
        req.getRequestDispatcher("squad.jsp").forward(req, resp);
    }
}
