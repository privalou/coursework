package servlets.matches;

import dao.DAO;
import dao.MatchDAO;
import dao.impl.MatchDAOImpl;
import model.Match;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/matches")
public class MatchesListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        DAO dao = (DAO) session.getAttribute("dao");
        MatchDAO matchDAO = new MatchDAOImpl(dao);
        List<Match> matches = matchDAO.getMatches();
        session.setAttribute("matches", matches);
        session.setAttribute("matchDao", dao);
        req.getRequestDispatcher("matches.jsp").forward(req,resp);
    }
}
