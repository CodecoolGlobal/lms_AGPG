package com.codecool.web.servlet;

import com.codecool.web.model.LoggedInUser;
import com.codecool.web.util.AssignmentUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


@WebServlet({"/assignment"})
public class AssignmentServlet extends AbstractServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        boolean published = Boolean.valueOf(request.getParameter("published")); //gomb
        String question = request.getParameter("question");
        int maxPoint = Integer.valueOf(request.getParameter("maxpoints")); //legördülő menu 1-5
        int mentor_id = LoggedInUser.getLoggedInUser().getId();

        try (Connection connection = getConnection(request.getServletContext())) {
            AssignmentUtil.addAssignment(connection, published, question, maxPoint, mentor_id);

        } catch (SQLException ex) {
            ex.printStackTrace();

        } catch (Exception e) {
            pw.println(e);
        }

        response.sendRedirect("view");

    }
}

