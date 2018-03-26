package servlets.players;

import dao.PlayerDAO;
import dao.TeamDAO;
import dao.impl.DAOPostgres;
import dao.impl.PlayerDAOImpl;
import dao.impl.TeamDAOImpl;
import model.Player;
import model.Team;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editPlayer")
public class EditPlayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeamDAO teamDAO = new TeamDAOImpl(DAOPostgres.getInstance());
        PlayerDAO playerDAO = new PlayerDAOImpl(DAOPostgres.getInstance());
        Player player = null;
        Team team;
        if (req.getParameter("playerId") != null) {
            int playerId = Integer.parseInt(req.getParameter("playerId"));
            player = playerDAO.getPlayer(playerId);
        }
        req.getSession().setAttribute("playerToEdit", player);
        team = teamDAO.getTeam(player.getTeamId());
        req.setAttribute("playersTeam", team);
        req.getRequestDispatcher("editPlayer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerName;
        int number;
        String playingPosition;
        Team team;
        if (req.getParameter("playerName") != null &&
                req.getParameter("number") != null &&
                req.getParameter("playingPosition") != null &&
                req.getParameter("teamSelector") != null) {
            TeamDAO teamDAO = new TeamDAOImpl(DAOPostgres.getInstance());
            PlayerDAO playerDAO = new PlayerDAOImpl(DAOPostgres.getInstance());
            playerName = req.getParameter("playerName");
            number = Integer.parseInt(req.getParameter("number"));
            playingPosition = req.getParameter("playingPosition");
            String teamName = req.getParameter("teamSelector");
            team = teamDAO.getTeam(teamName);
            Player player = (Player) req.getSession().getAttribute("playerToEdit");
            player.setPlayerName(playerName);
            player.setNumber(number);
            player.setPlayerPosition(playingPosition);
            player.setTeamId(team.getTeamId());
            playerDAO.updatePlayer(player);
            resp.sendRedirect("/squad?teamId=" + team.getTeamId());
        }
    }
}
