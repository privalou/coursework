package servlets.matches;

import dao.MatchDAO;
import dao.PlayerDAO;
import dao.impl.DAOPostgres;
import dao.impl.MatchDAOImpl;
import dao.impl.TeamDAOImpl;

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
        MatchDAO matchDAO = new MatchDAOImpl(DAOPostgres.getInstance());
        if (req.getParameter("matchId") != null) {
            int matchId = Integer.parseInt(req.getParameter("matchId"));
            matchDAO.deleteMatch(matchId);
        }
        resp.sendRedirect("matches");
    }
}
