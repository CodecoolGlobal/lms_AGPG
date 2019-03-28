package com.codecool.web.servlet;

import com.codecool.web.model.LoggedInUser;
import com.codecool.web.model.User;
import com.codecool.web.model.Users;
import com.codecool.web.service.ServletHelper;
import com.codecool.web.service.XMLparser;
import com.codecool.web.util.AnswerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet({"", "/login"})
public class LoginServlet extends AbstractServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //mycode starts
        try (Connection connection = getConnection(request.getServletContext())) {

            //String ans =  Dao.getDao(connection);
            AnswerUtil.insertName(connection);
            

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

        //mycode ends

        String asd = request.getServletContext().getRealPath("data.xml");

        String user_email = request.getParameter("email");
        String user_pass = request.getParameter("psw");

        User[] users = XMLparser.read(asd);

        if (ServletHelper.isRegistered(user_email, user_pass, asd)) {
            LoggedInUser loggedInUser = new LoggedInUser();
            loggedInUser.setEmailAddress(user_email);

            request.setAttribute("name", ServletHelper.showUserName(user_email, asd));

            String name = ServletHelper.showUserName(user_email, asd);
            LoggedInUser.setLoggedInUserName(name);

            User[] userss = XMLparser.read(asd);
            Users u = new Users();
            u.setUsers(userss);

            //request.getRequestDispatcher("view").forward(request, response);

            response.sendRedirect("view");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);

    }
}
