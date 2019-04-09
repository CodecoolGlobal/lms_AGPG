package com.codecool.web.servlet;

import com.codecool.web.model.Attendance;
import com.codecool.web.service.AttendanceService;
import com.codecool.web.util.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;


@WebServlet({"/attendance"})
public class AttendanceServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date");
        long milis = AttendanceService.getMilis(date);
        Date datesql = new Date(milis);


        String[] attendances = request.getParameterValues("attendance");

        try (Connection connection = getConnection(request.getServletContext())) {
            request.setAttribute("userList", UserUtil.getUsers(connection));
        } catch (SQLException ex) {
            ex.getMessage();
        }

        request.getRequestDispatcher("attendance.jsp").forward(request, response);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("attendance.jsp");

    }

}
