package com.codecool.web.servlet;

import com.codecool.web.model.LoggedInUser;
import com.codecool.web.model.TextPage;
import com.codecool.web.util.AnswerUtil;
import com.codecool.web.util.TextPageUtil;
import com.codecool.web.util.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/viewstatistics"})
public class StatisticServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        boolean isPublished = Boolean.valueOf(request.getParameter("published"));
        String titleOfText = request.getParameter("textpage_title");
        String textValue = request.getParameter("textpage_value");

        try (Connection connection = getConnection(request.getServletContext())) {
            TextPageUtil.addTextPage(connection, isPublished, titleOfText, textValue);

        } catch (SQLException ex) {
            ex.printStackTrace();

        } catch (Exception e) {
            pw.println(e);
        }

        response.sendRedirect("view");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try (Connection connection = getConnection(request.getServletContext())) {
            request.setAttribute("fullName", LoggedInUser.getLoggedInUser().getfName());
            request.setAttribute("userId", LoggedInUser.getLoggedInUser().getId());
            request.setAttribute("grade", );
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
}

