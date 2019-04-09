package com.codecool.web.servlet;

import com.codecool.web.util.AnswerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/grade")
public class GradeServlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            PrintWriter pw = resp.getWriter();
            String assignmentId = req.getParameter("id");
            String studentId = AnswerUtil.
            req.setAttribute("grade", AnswerUtil.grade(connection, assignmentId,);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        req.getRequestDispatcher("show-grade.jsp").forward(req, resp);
    }
}
