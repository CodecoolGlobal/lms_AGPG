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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            PrintWriter pw = resp.getWriter();
            String assignmentId = req.getParameter("id");
            String grade = req.getParameter("grade");
            int studentId = AnswerUtil.getStudentIdByAssignmentId(connection, Integer.valueOf(assignmentId));
            AnswerUtil.grade(connection, Integer.valueOf(assignmentId), studentId, Integer.valueOf(grade));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        req.getRequestDispatcher("show-answers.jsp").forward(req, resp);
    }
}
