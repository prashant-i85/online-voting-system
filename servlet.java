package com.voting.controller;

import com.voting.dao.VoterDAO;
import com.voting.model.Voter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
