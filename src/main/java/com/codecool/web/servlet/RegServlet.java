package com.codecool.web.servlet;

import com.codecool.web.model.User;
import com.codecool.web.util.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/reg")
public class RegServlet extends AbstractServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String user_name = request.getParameter("fullname");
        String user_email = request.getParameter("email");
        String user_pass = request.getParameter("psw");

        boolean position = request.getParameter("position").equals("mentor");

        String redirectUrl = "";
        try (Connection connection = getConnection(request.getServletContext())) {
            if (!UserUtil.isEmailUsed(connection, user_email)) {
                User user = new User(user_name, user_email, user_pass, position);

                UserUtil.createUser(connection, user);
                redirectUrl = "login.jsp";
            } else {
                redirectUrl = "registration.html";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            //throw new ServletException(ex);
        }
        response.sendRedirect(redirectUrl);
    }
}
