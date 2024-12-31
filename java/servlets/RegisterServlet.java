package servlets;

import dao.VoterDAO;
import model.Voter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Voter voter = new Voter();
        voter.setName(name);
        voter.setEmail(email);
        voter.setPassword(password);

        VoterDAO voterDAO = new VoterDAO();
        boolean success = voterDAO.registerVoter(voter);

        if (success) {
            response.sendRedirect("login.jsp?registered=true");
        } else {
            response.sendRedirect("register.jsp?error=true");
        }
    }
}
