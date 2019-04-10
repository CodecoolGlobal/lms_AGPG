package com.codecool.web.servlet;

import com.codecool.web.model.User;
import com.codecool.web.service.AttendanceService;
import com.codecool.web.util.AttendanceUntil;
import com.codecool.web.util.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet({"/attendance"})
public class AttendanceServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] attendances = request.getParameterValues("attendance");

        String ver1 = request.getParameter("hiddenDate");
        request.setAttribute("middleDate", ver1);
        List<User> users;
        List<User> presentUsers;

        Date sqlDate = new Date(AttendanceService.getMilis(ver1));
        try (Connection connection = getConnection(request.getServletContext())) {
            users = UserUtil.getUsers(connection);
            presentUsers = AttendanceUntil.ModifyUsersPresent(users, attendances);

            AttendanceService.modifyAttendanceDb(connection, presentUsers, sqlDate);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("attendance?date=" + ver1);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ver1 = req.getParameter("date");
        String backInTimeDay = AttendanceService.backInTime(ver1, 1, 0);
        String backInTimeWeek = AttendanceService.backInTime(ver1, 7, 0);
        String backInTimeMonth = AttendanceService.backInTime(ver1, 0, 1);
        req.setAttribute("middleDate", ver1);

        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection(req.getServletContext())) {
            Date sqlDate = new Date(AttendanceService.getMilis(ver1));
            if (AttendanceUntil.isDateUsed(connection, sqlDate)) {
                userList = AttendanceUntil.setUsersPresent(connection, sqlDate, UserUtil.getUsers(connection));
            } else {
                userList = UserUtil.getUsers(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("backInTimeDay", backInTimeDay);
        req.setAttribute("backInTimeWeek", backInTimeWeek);
        req.setAttribute("backInTimeMonth", backInTimeMonth);
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("attendance.jsp").forward(req, resp);
    }
}
