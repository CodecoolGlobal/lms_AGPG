package com.codecool.web.servlet;

import com.codecool.web.model.LoggedInUser;
import com.codecool.web.util.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/myprofile")
public class ProfileServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("email", LoggedInUser.getLoggedInUser().getEmail());
        boolean currentPosition = LoggedInUser.getLoggedInUser().isMentor();
        String newName = request.getParameter("fullname");
        boolean isPositionGiven = false;
        boolean newPosition = false;
        if (request.getParameter("position") != null) {
            isPositionGiven = true;
            newPosition = request.getParameter("position").equals("mentor");
        }
        try (Connection connection = getConnection(request.getServletContext())) {

            if (newName.length() > 0) {
                UserUtil.Update(connection, LoggedInUser.getLoggedInUser(), "user_name", newName);
                LoggedInUser.getLoggedInUser().setfName(newName);
            }
            if (isPositionGiven && currentPosition != newPosition) {
                UserUtil.Update(connection, LoggedInUser.getLoggedInUser(), "ismentor", newPosition);
                LoggedInUser.getLoggedInUser().setMentor(newPosition);
            }
        } catch (SQLException ex) {
            //throw new ServletException(ex);
        }
        response.sendRedirect("show-profile.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("email", LoggedInUser.getLoggedInUser().getEmail());
        resp.sendRedirect("show-profile.jsp");
    }
}


