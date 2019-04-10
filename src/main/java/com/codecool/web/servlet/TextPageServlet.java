package com.codecool.web.servlet;

import com.codecool.web.model.LoggedInUser;
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


@WebServlet({"/addtextpage"})
public class TextPageServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();


        boolean isPublished = Boolean.valueOf(request.getParameter("published"));
        String titleOfText = request.getParameter("textpage_title");
        String textValue = request.getParameter("textpage_value");
        int mentor_id = LoggedInUser.getLoggedInUser().getId();

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
            List<TextPage> textPageList = TextPageUtil.getTextPages(connection);
            request.setAttribute("textpages", textPageList);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            request.getRequestDispatcher("show-textpages.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
