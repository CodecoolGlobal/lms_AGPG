package com.codecool.web.servlet;

import com.codecool.web.model.Greeting;
import com.codecool.web.model.User;
import com.codecool.web.service.GreetingService;
import com.codecool.web.service.XMLparser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String asd = request.getServletContext().getRealPath("data.xml");

        String user_name = request.getParameter("fullname");
        String user_email = request.getParameter("email");
        String user_pass = request.getParameter("psw");

        Boolean position = false;
        if (request.getParameter("position").equals("mentor")){
            position = true;
        }


        User u = new User(user_name, user_email, user_pass,position );
        XMLparser.write(u, asd);

        response.sendRedirect("login.jsp");
    }
}
