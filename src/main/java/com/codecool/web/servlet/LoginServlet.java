package com.codecool.web.servlet;

import com.codecool.web.model.LoggedInUser;
import com.codecool.web.model.User;
import com.codecool.web.util.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"", "/login"})
public class LoginServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user_email = request.getParameter("email");
        String user_pass = request.getParameter("psw");
        HttpSession session = request.getSession(false);
        session.setAttribute("email", user_email);
        user_email = (String) session.getAttribute("email");
        String redirectUrl = "";
        try (Connection connection = getConnection(request.getServletContext())) {
            List<User> users = UserUtil.getUsers(connection);
            if (UserUtil.isRegistrated(connection, user_email, user_pass)) {
                redirectUrl = "view";
                LoggedInUser.setLoggedInUser(UserUtil.findUserByEmail(connection, user_email));
            } else {
                redirectUrl = "login";
            }
        } catch (SQLException ex) {
            //throw new ServletException(ex);
        } /*catch (ServiceException ex) {
            request.setAttribute("error", ex.getMessage());
        }*/
        response.sendRedirect(redirectUrl);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }
}
