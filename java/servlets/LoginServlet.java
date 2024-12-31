package servlets;

import dao.VoterDAO;
import model.Voter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        VoterDAO voterDAO = new VoterDAO();
        Voter voter = voterDAO.authenticateVoter(email, password);

        if (voter != null) {
            HttpSession session = request.getSession();
            session.setAttribute("voter", voter);
            response.sendRedirect("voting.jsp");
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
