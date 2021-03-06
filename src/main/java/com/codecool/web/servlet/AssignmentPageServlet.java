package com.codecool.web.servlet;

import com.codecool.web.util.AssignmentUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/assignment-page")
public class AssignmentPageServlet extends AbstractServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            String id = req.getParameter("id");
            req.setAttribute("assignment", AssignmentUtil.getAssignmentById(connection, Integer.valueOf(id)));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        req.getRequestDispatcher("add-solution.jsp").forward(req, resp);
    }
}
