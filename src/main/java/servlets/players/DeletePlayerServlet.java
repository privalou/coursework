package servlets.players;

import dao.PlayerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deletePlayer")
public class DeletePlayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PlayerDAO playerDAO = (PlayerDAO) session.getAttribute("playerDao");
        if (req.getParameter("playerId") != null) {
            int playerId = Integer.parseInt(req.getParameter("playerId"));
            playerDAO.deletePlayer(playerId);
        }
        resp.sendRedirect("teamList");
    }

}
