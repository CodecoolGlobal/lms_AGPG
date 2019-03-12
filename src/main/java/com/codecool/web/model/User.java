package com.codecool.web.model;

public class User {
    private String fName;
    private String email;
    private String pw;
    private boolean isMentor;

    public User(String fName, String email, String pw, boolean isMentor) {
        this.fName = fName;
        this.email = email;
        this.pw = pw;
        this.isMentor = isMentor;
    }

    public String getfName() {
        return fName;
    }

    public String getEmail() {
        return email;
    }

    public String getPw() {
        return pw;
    }

    public boolean isMentor() {
        return isMentor;
    }
}
