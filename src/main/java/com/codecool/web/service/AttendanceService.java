package com.codecool.web.service;

import com.codecool.web.model.User;
import com.codecool.web.util.AttendanceUntil;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AttendanceService {
    public static long getMilis(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date convertedCurrentDate = sdf.parse(date);
            long time = convertedCurrentDate.getTime();
            return time;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getCurrentDate() { // Used in attendance.jsp
        String pattern = "MM/dd/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }

    public static String backInTime(String stringDate, int days, int months) {
        String pattern = "MM/dd/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = new Date();

        Calendar c = Calendar.getInstance();
        String[] dateSplit= new String[3];

        int i = 0;
        for (String s : stringDate.split("/")){
            dateSplit[i] = s;
            i++;
        }

        c.set(Calendar.MONTH, Integer.parseInt(dateSplit[0])-1-months); // counter
        c.set(Calendar.DATE, Integer.parseInt(dateSplit[1])-days);
        c.set(Calendar.YEAR, Integer.parseInt(dateSplit[2]));

        date = c.getTime();
        return df.format(date);
    }

    public static String getTomorrow() {
        String pattern = "MM/dd/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);

        date = c.getTime();
        return df.format(date);
    }

    public static void modifyAttendanceDb(Connection connection, List<User> users, java.sql.Date date) throws SQLException {

        for (User user : users) {
            if (user.isPresent()) {
                if (!AttendanceUntil.isUserPresentwithDate(connection, date, user.getId())) {// !user IS IN DB && DATE = date_att
                    AttendanceUntil.addAttendance(connection, date, user.getId());
                }
            } else { // user IS IN DB && DATE
                AttendanceUntil.removeAttendance(connection, date, user.getId());
            }
        }
    }
}
