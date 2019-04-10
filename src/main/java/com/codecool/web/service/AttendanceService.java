package com.codecool.web.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AttendanceService {
    public static long getMilis(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date convertedCurrentDate = sdf.parse(date);
            long time = convertedCurrentDate.getTime();
            return time;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
