package com.codecool.web.model;

import java.util.Date;

public class Attendance {
    private int userid;
    private Date date;

    public Attendance(int userid, Date date) {
        this.userid = userid;
        this.date = date;
    }

    public int getUserid() {
        return userid;
    }

    public Date getDate() {
        return date;
    }


}
