package servlets;

import dao.VoteDAO;
import model.Vote;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class VoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int candidateId = Integer.parseInt(request.getParameter("candidateId"));
        int electionId = Integer.parseInt(request.getParameter("electionId"));
        Voter voter = (Voter) request.getSession().getAttribute("voter");

        if (voter == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        VoteDAO voteDAO = new VoteDAO();
        Vote vote = new Vote();
        vote.setVoterId(voter.getVoterId());
        vote.setCandidateId(candidateId);
        vote.setElectionId(electionId);

        boolean success = voteDAO.castVote(vote);

        if (success) {
            response.sendRedirect("results.jsp");
        } else {
            response.sendRedirect("voting.jsp?error=true");
        }
    }
}
