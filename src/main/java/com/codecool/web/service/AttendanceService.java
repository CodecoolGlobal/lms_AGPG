package com.codecool.web.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    public static String getYesterday() {
        String pattern = "MM/dd/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -1);

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
}
