package com.codecool.web.model;

public class LoggedInUser extends User{

    private static User loggedInUser;


    public LoggedInUser(String fName, String email, String pw, boolean isMentor) {
        super(fName,email,pw,isMentor);
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User user) {
        loggedInUser = user;
    }

}
