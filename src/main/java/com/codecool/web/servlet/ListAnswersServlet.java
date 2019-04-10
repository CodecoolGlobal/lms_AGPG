package com.codecool.web.servlet;

import com.codecool.web.util.AnswerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/list-answers")
public class ListAnswersServlet extends AbstractServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id;
        try (Connection connection = getConnection(req.getServletContext())) {
            id = req.getParameter("id");
            req.setAttribute("testId", id);
            req.setAttribute("answerList", AnswerUtil.getAnswerList(connection, Integer.valueOf(id)));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        req.getRequestDispatcher("show-answers.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

