package com.codecool.web.model;

public class LoggedInUser{
    private static String emailAddress;

    public static String getLoggedInUserName() {
        return LoggedInUserName;
    }

    public static void setLoggedInUserName(String loggedInUserName) {
        LoggedInUserName = loggedInUserName;
    }

    private static String LoggedInUserName;

    public static String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
