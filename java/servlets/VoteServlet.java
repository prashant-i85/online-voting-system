package servlets;

import dao.CandidateDAO;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class VoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String candidateId = request.getParameter("candidateId");
        String message = "";
        String messageType = "alert-danger";

        if (candidateId != null && !candidateId.isEmpty()) {
            try {
                // Process the vote
                CandidateDAO candidateDAO = new CandidateDAO();
                boolean voteProcessed = candidateDAO.castVote(Integer.parseInt(candidateId));

                if (voteProcessed) {
                    message = "Your vote has been successfully cast!";
                    messageType = "alert-success";
                } else {
                    message = "There was an error processing your vote. Please try again.";
                }

                // Set message and forward to voting.jsp
                request.setAttribute("message", message);
                request.setAttribute("messageType", messageType);

                // Retrieve updated candidates list
                List<Candidate> candidates = candidateDAO.getCandidates();
                request.setAttribute("candidates", candidates);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/voting.jsp");
                dispatcher.forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
                message = "Error: " + e.getMessage();
                request.setAttribute("message", message);
                request.setAttribute("messageType", "alert-danger");
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/voting.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            message = "Please select a candidate to vote.";
            request.setAttribute("message", message);
            request.setAttribute("messageType", "alert-danger");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/voting.jsp");
            dispatcher.forward(request, response);
        }
    }
}
