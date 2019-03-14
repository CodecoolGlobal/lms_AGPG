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
        String user_roleS = request.getParameter("position");
        LoggedInUser.setIsMentor(ServletHelper.isMenorold(LoggedInUser.getEmailAddress(), asd)); // old role
        Boolean role = LoggedInUser.getIsMentor();
        String oldName = LoggedInUser.getLoggedInUserName();

        if (user_roleS != null){
            role = user_roleS.equals("mentor") ? true : false;

        }



        if (user_pass.length() == 0) {
            LoggedInUser.setOldPassw(ServletHelper.getOldPw(LoggedInUser.getEmailAddress(), asd));
            user_pass = LoggedInUser.getOldPassw();
        }

        if (user_name.length() == 0){
            user_name = LoggedInUser.getLoggedInUserName();
        }

        LoggedInUser.setLoggedInUserName(user_name);

        XMLparser.update(asd, oldName, user_name, user_pass, role);
        response.sendRedirect("curriculum-myprofile.jsp");

        Users.setUsers(XMLparser.read(asd));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String asd = req.getServletContext().getRealPath("data.xml");

        req.setAttribute("name", ServletHelper.showUserName(LoggedInUser.getEmailAddress(), asd));

        req.getRequestDispatcher("curriculum-myprofile.jsp").forward(req, resp);

    }

}

