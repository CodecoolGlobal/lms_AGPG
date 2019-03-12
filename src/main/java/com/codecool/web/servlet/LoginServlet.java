package com.codecool.web.servlet;

import com.codecool.web.model.User;
import com.codecool.web.service.XMLparser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String asd = request.getServletContext().getRealPath("data.xml");

        String user_email = request.getParameter("email");
        String user_pass = request.getParameter("psw");

        User[] users = XMLparser.read(asd);

        boolean isFind = false;
        for (User user : users) {
            if (user.getEmail().equals(user_email) && user.getPw().equals(user_pass)) {
                isFind = true;
            }
        }

        if (isFind){
            response.sendRedirect("index.html");
        }
        else {
            response.sendRedirect("login.html");
        }
    }
}
