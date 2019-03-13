package com.codecool.web.servlet;

import com.codecool.web.model.User;
import com.codecool.web.model.Users;
import com.codecool.web.service.XMLparser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String asd = request.getServletContext().getRealPath("data.xml");

    }

}

