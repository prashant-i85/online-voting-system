package servlets;

import dao.VoterDAO;
import dao.CandidateDAO;
import model.Voter;
import model.Candidate;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            VoterDAO voterDAO = new VoterDAO();
            Voter voter = voterDAO.login(email, password);

            if (voter != null) {
                HttpSession session = request.getSession();
                session.setAttribute("voter", voter);
                response.sendRedirect("voting.jsp");
            } else {
                response.sendRedirect("login.jsp?error=Invalid credentials");
            }
        }
    }
}
