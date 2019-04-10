package com.codecool.web.servlet;

import com.codecool.web.model.Assignment;
import com.codecool.web.model.LoggedInUser;
import com.codecool.web.util.AnswerUtil;
import com.codecool.web.util.AssignmentUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/view")
public class ViewServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req.getRequestDispatcher("show-student-assignments.jsp").forward(req, resp);
        if (LoggedInUser.getLoggedInUser().isMentor()) {
            try (Connection connection = getConnection(req.getServletContext())) {
                req.setAttribute("assignment", AssignmentUtil.getAssignments(connection));
            } catch (SQLException ex) {
                ex.getMessage();
            }
            req.getRequestDispatcher("show-mentor-assignments.jsp").forward(req, resp);
        } else {
            List<Assignment> publishedAsgn = new ArrayList<>();

            try (Connection connection = getConnection(req.getServletContext())) {
                for (Assignment assignment : AssignmentUtil.getAssignments(connection)) {
                    if (assignment.isPublished() && !AnswerUtil.isAnswered(connection, assignment.getAssignmentId(), LoggedInUser.getLoggedInUser().getId())) {
                        publishedAsgn.add(assignment);
                    }
                }
                req.setAttribute("assignment", publishedAsgn);
            } catch (SQLException ex) {
                ex.getMessage();
            }
            req.getRequestDispatcher("show-student-assignments.jsp").forward(req, resp);
        }
    }
}
