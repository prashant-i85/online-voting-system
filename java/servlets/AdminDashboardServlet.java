package servlets;

import dao.ElectionDAO;
import dao.CandidateDAO;
import model.Election;
import model.Candidate;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class AdminDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        ElectionDAO electionDAO = new ElectionDAO();

        if ("viewElections".equals(action)) {
            List<Election> elections = electionDAO.getAllElections();
            request.setAttribute("elections", elections);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin_dashboard.jsp");
            dispatcher.forward(request, response);
        } else if ("createElection".equals(action)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("create_election.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        Election election = new Election();
        election.setTitle(title);
        election.setDescription(description);
        election.setStartDate(startDate);
        election.setEndDate(endDate);

        ElectionDAO electionDAO = new ElectionDAO();
        boolean success = electionDAO.createElection(election);

        if (success) {
            response.sendRedirect("admin_dashboard.jsp");
        } else {
            response.sendRedirect("create_election.jsp?error=true");
        }
    }
}
