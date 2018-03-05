package servlets.matches;

import dao.MatchDAO;
import dao.PlayerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteMatch")
public class DeleteMatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MatchDAO matchDAO = (MatchDAO) session.getAttribute("matchDao");
        if (req.getParameter("matchId") != null) {
            int matchId = Integer.parseInt(req.getParameter("matchId"));
            matchDAO.deleteMatch(matchId);
        }
        resp.sendRedirect("matches");
    }
}
