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

@WebServlet({"", "/greeting"})
public class GreetingServlet extends HttpServlet {

    private final GreetingService service = new GreetingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Greeting> greetings = service.getGreetings();
        req.setAttribute("greetings", greetings);

        boolean jstl = Boolean.valueOf(req.getParameter("jstl"));
        if (jstl) {
            req.getRequestDispatcher("greeting-jstl.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String user_name = request.getParameter("fullname");
        String user_email = request.getParameter("email");
        String user_pass = request.getParameter("psw");
        Boolean position = Boolean.valueOf(request.getParameter("position"));

        User u = new User(user_name, user_email, user_pass, position);
    }
}
