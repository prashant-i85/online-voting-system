package servlets;

import dao.CandidateDAO;
import dao.VoteDAO;
import model.Candidate;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ResultServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int electionId = Integer.parseInt(request.getParameter("electionId"));

        CandidateDAO candidateDAO = new CandidateDAO();
        VoteDAO voteDAO = new VoteDAO();
        List<Candidate> candidates = candidateDAO.getCandidatesByElection(electionId);

        for (Candidate candidate : candidates) {
            int totalVotes = voteDAO.getTotalVotes(candidate.getCandidateId());
            candidate.setVotes(totalVotes);
        }

        request.setAttribute("candidates", candidates);
        RequestDispatcher dispatcher = request.getRequestDispatcher("results.jsp");
        dispatcher.forward(request, response);
    }
}
