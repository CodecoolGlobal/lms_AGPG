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

        /* TODO IMPLEMENT SAVE
          SAVE TO DATABASE
        * WITH SAVE BUTTON*/

        String date = request.getParameter("date");
        //long milis = AttendanceService.getMilis(date);
        //Date datesql = new Date(milis);


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
        String ver1 = req.getParameter("date");
        req.setAttribute("middleDate", ver1);

        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection(req.getServletContext())) {
            Date sqlDate = new Date(AttendanceService.getMilis(ver1));
            if (AttendanceUntil.isDateUsed(connection, sqlDate)) {
                userList =AttendanceUntil.setUsersPresent(connection,sqlDate, UserUtil.getUsers(connection));
            }
            else {
                userList = UserUtil.getUsers(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("attendance.jsp").forward(req,resp);
    }
}
