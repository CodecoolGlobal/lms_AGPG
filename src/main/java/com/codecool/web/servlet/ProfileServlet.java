package com.codecool.web.servlet;

import com.codecool.web.model.LoggedInUser;
import com.codecool.web.model.User;
import com.codecool.web.model.Users;
import com.codecool.web.service.ServletHelper;
import com.codecool.web.service.XMLparser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showname")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String asd = request.getServletContext().getRealPath("data.xml");

        String user_name = request.getParameter("fullname");
        String user_pass = request.getParameter("psw");
        String oldName = LoggedInUser.getLoggedInUserName();

        LoggedInUser.setLoggedInUserName(user_name);

        XMLparser.update(asd, oldName,user_name,user_pass);
        response.sendRedirect("curriculum-myprofile.jsp");

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String asd = req.getServletContext().getRealPath("data.xml");

        req.setAttribute("name", ServletHelper.showUserName(LoggedInUser.getEmailAddress(),asd));

        req.getRequestDispatcher("curriculum-myprofile.jsp").forward(req, resp);

    }

}

