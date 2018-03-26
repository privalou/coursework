package servlets.players;

import dao.PlayerDAO;
import dao.impl.DAOPostgres;
import dao.impl.PlayerDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletePlayer")
public class DeletePlayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlayerDAO playerDAO = new PlayerDAOImpl(DAOPostgres.getInstance());
        if (req.getParameter("playerId") != null) {
            int playerId = Integer.parseInt(req.getParameter("playerId"));
            playerDAO.deletePlayer(playerId);
        }
        resp.sendRedirect("teamList");
    }

}
