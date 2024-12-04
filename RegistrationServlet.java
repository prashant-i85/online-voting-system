package com.voting.servlet;

import com.voting.dao.UserDAO;
import com.voting.model.User;
import com.voting.util.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = "voter"; // Default role

        try {
            UserDAO userDAO = new UserDAO(DBConnection.getConnection());
            User user = new User(username, password, role);
            if (userDAO.registerUser(user)) {
                response.sendRedirect("login.jsp?message=Registration successful");
            } else {
                response.sendRedirect("register.jsp?error=Registration failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=Server error");
        }
    }
}
