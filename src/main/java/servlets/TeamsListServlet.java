package servlets;

import dao.DAO;
import dao.TeamDAO;
import dao.impl.DAOPostgres;
import dao.impl.TeamDAOImpl;
import model.Team;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/index.jsp")
public class TeamsListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO dao = new DAOPostgres();
        dao.setURL(DAOPostgres.DEFAULT_HOST, DAOPostgres.DEFAULT_DATABASE, DAOPostgres.DEFAULT_PORT);
        dao.connect(DAOPostgres.DEFAULT_LOGIN, DAOPostgres.DEFAULT_PASSWORD);
        TeamDAO teamDAO = new TeamDAOImpl(dao);
        List<Team> teams = teamDAO.getTeams();
        HttpSession session = req.getSession();
        session.setAttribute("teams", teams);
        req.setAttribute("teams", teams);
        resp.sendRedirect("http://localhost:8080/teamList.jsp");
    }

}
