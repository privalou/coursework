package servlets.matches;

import dao.MatchDAO;
import dao.TeamDAO;
import dao.impl.DAOPostgres;
import dao.impl.MatchDAOImpl;
import dao.impl.TeamDAOImpl;
import model.Match;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/matches")
public class MatchesListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MatchDAO matchDAO = new MatchDAOImpl(DAOPostgres.getInstance());
        List<Match> matches = matchDAO.getMatches();
        TeamDAO teamDAO = new TeamDAOImpl(DAOPostgres.getInstance());
        req.setAttribute("teamDao", teamDAO);
        req.setAttribute("matches", matches);
        req.getRequestDispatcher("matches.jsp").forward(req,resp);
    }
}
