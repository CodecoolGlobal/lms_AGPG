package com.codecool.web.servlet;

import com.codecool.web.model.User;
import com.codecool.web.service.ServletHelper;
import com.codecool.web.service.XMLparser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String asd = request.getServletContext().getRealPath("data.xml");

        String user_name = request.getParameter("fullname");
        String user_email = request.getParameter("email");
        String user_pass = request.getParameter("psw");

        boolean position = false;
        if (request.getParameter("position").equals("mentor")) {
            position = true;
        }

        if(ServletHelper.isValidEmail(user_email, asd)){
            User u = new User(1, user_name, user_email, user_pass, position);
            XMLparser.write(u, asd);
            response.sendRedirect("login.jsp");
        }
        else {
            response.sendRedirect("registration.html");
        }
    }
}
