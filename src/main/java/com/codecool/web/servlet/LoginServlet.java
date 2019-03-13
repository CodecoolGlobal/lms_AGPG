package com.codecool.web.servlet;

import com.codecool.web.model.LoggedInUser;
import com.codecool.web.model.User;
import com.codecool.web.service.ServletHelper;
import com.codecool.web.service.XMLparser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"","/login"})
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String asd = request.getServletContext().getRealPath("data.xml");

        String user_email = request.getParameter("email");
        String user_pass = request.getParameter("psw");

        User[] users = XMLparser.read(asd);

        if (ServletHelper.isRegistered(user_email, user_pass, asd)) {
            LoggedInUser loggedInUser = new LoggedInUser();
            loggedInUser.setEmailAddress(user_email);
            request.setAttribute("email",user_email);

            request.getRequestDispatcher("index.jsp").forward(request, response);

            //response.sendRedirect("index.jsp");
        } else {

            response.sendRedirect("login.html");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.html").forward(req, resp);

    }
}
