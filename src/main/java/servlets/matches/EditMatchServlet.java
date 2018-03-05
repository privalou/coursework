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

@WebServlet("/editMatch")
public class EditMatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        TeamDAO teamDAO = (TeamDAO) session.getAttribute("teamDao");
        MatchDAO matchDAO = (MatchDAO) session.getAttribute("matchDao");
        Match match;
        if (req.getParameter("matchId") != null) {
            int matchId = Integer.parseInt(req.getParameter("matchId"));
            match = matchDAO.getMatch(matchId);
            session.setAttribute("matchToEdit", match);
            Team homeTeam = teamDAO.getTeam(match.getHomeTeamId());
            Team guestTeam = teamDAO.getTeam(match.getGuestTeamId());
            session.setAttribute("homeTeam", homeTeam);
            session.setAttribute("guestTeam", guestTeam);
            req.getRequestDispatcher("editMatch.jsp").forward(req, resp);
        }
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
                req.getParameter("stadium") != null &&
                req.getParameter("homeTeamScore") != null &&
                req.getParameter("guestTeamScore") != null) {
            HttpSession session = req.getSession();
            Match match = (Match) session.getAttribute("matchToEdit");
            TeamDAO teamDAO = (TeamDAO) session.getAttribute("teamDao");
            MatchDAO matchDAO = (MatchDAO) session.getAttribute("matchDao");
            homeTeam = teamDAO.getTeam(req.getParameter("teamSelectorHome"));
            guestTeam = teamDAO.getTeam(req.getParameter("teamSelectorGuest"));
            String matchdayReq = req.getParameter("matchday");
            if (req.getParameter("matchday").equals("")) {
                matchday = match.getMatchday();
            } else {
                matchday = Date.valueOf(req.getParameter("matchday"));
            }
            stadium = req.getParameter("stadium");
            homeTeamScore = Integer.parseInt(req.getParameter("homeTeamScore"));
            guestTeamScore = Integer.parseInt(req.getParameter("guestTeamScore"));
            match.setHomeTeamId(homeTeam.getTeamId());
            match.setGuestTeamId(guestTeam.getTeamId());
            match.setMatchday(matchday);
            match.setStadium(stadium);
            match.setHomeTeamScore(homeTeamScore);
            match.setGuestTeamScore(guestTeamScore);
            matchDAO.updateMatch(match);
            resp.sendRedirect("/matches");
        }
    }
}
