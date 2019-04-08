package com.codecool.web.servlet;

import com.codecool.web.model.LoggedInUser;
import com.codecool.web.util.AnswerUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet({"/answer"})
public class AnswerServlet extends AbstractServlet {
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        int assignmentId = Integer.valueOf(request.getParameter("id"));
        String textValue = request.getParameter("answer");
        int id = LoggedInUser.getLoggedInUser().getId();
        
        try (Connection connection = getConnection(request.getServletContext())) {
            AnswerUtil.addAnswer(connection, assignmentId, id, textValue);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } catch (Exception e) {
            pw.println(e);
        }
        response.sendRedirect("view");
    }
}
