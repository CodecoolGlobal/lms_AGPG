package com.codecool.web.servlet;

import com.codecool.web.util.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/userlist")
public class UserListServlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            req.setAttribute("userList", UserUtil.getUsers(connection));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        req.getRequestDispatcher("show-users.jsp").forward(req, resp);
    }
}
