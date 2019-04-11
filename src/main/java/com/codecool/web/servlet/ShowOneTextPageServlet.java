package com.codecool.web.servlet;

import com.codecool.web.model.TextPage;
import com.codecool.web.util.TextPageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/show-textcontent"})
public class ShowOneTextPageServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try (Connection connection = getConnection(request.getServletContext())) {
            String textTitle = request.getParameter("text-title");
            String textContent = request.getParameter("text-content");
            request.setAttribute("text-title", textTitle);
            request.setAttribute("text-content", textContent);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            request.getRequestDispatcher("show-textpage.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
