package com.codecool.web.servlet;

import com.codecool.web.model.LoggedInUser;
import com.codecool.web.model.Statistic;
import com.codecool.web.util.GradeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet({"/viewstatistics"})
public class StatisticServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        try (Connection connection = getConnection(request.getServletContext())) {
            Statistic userDetails = GradeUtil.getAnswersForLoggedInUser(connection, LoggedInUser.getLoggedInUser().getId());
            request.setAttribute("assignmentId", userDetails.getAssignmentIdList());
            request.setAttribute("questions", userDetails.getQuestionsList());
            request.setAttribute("answers", userDetails.getAnswersList());
            request.setAttribute("grades", userDetails.getGradesList());

            request.getRequestDispatcher("show-statistics.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.getMessage();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}

