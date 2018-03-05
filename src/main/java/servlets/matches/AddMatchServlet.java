package servlets.matches;

import dao.MatchDAO;
import dao.PlayerDAO;
import dao.TeamDAO;
import model.Match;
import model.Player;
import model.Team;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/addMatch")
public class AddMatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addMatch.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Team homeTeam;
        Team guestTeam;
        Date matchday;
        String stadium;
        int homeTeamScore;
        int guestTeamScore;
        if (req.getParameter("teamSelectorHome") != null &&
                req.getParameter("teamSelectorGuest") != null &&
                req.getParameter("matchday") != null &&
                req.getParameter("stadium") != null &&
                req.getParameter("homeTeamScore") != null &&
                req.getParameter("guestTeamScore") != null) {
            HttpSession session = req.getSession();
            TeamDAO teamDAO = (TeamDAO) session.getAttribute("teamDao");
            MatchDAO matchDAO = (MatchDAO) session.getAttribute("matchDao");
            homeTeam = teamDAO.getTeam(req.getParameter("teamSelectorHome"));
            guestTeam = teamDAO.getTeam(req.getParameter("teamSelectorGuest"));
            matchday = Date.valueOf(req.getParameter("matchday"));
            stadium = req.getParameter("stadium");
            homeTeamScore = Integer.parseInt(req.getParameter("homeTeamScore"));
            guestTeamScore = Integer.parseInt(req.getParameter("guestTeamScore"));
            Match match = new Match(homeTeam.getTeamId(),
                    guestTeam.getTeamId(),
                    matchday,
                    stadium,
                    homeTeamScore,
                    guestTeamScore);
            matchDAO.addMatch(match);
            resp.sendRedirect("/matches");
        }
    }
}
