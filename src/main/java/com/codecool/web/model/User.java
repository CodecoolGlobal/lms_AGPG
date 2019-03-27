package com.codecool.web.model;

public class User {
    private String fName;
    private String email;
    private String pw;
    private boolean mentor;
    private int id;

    public User(int id, String fName, String email, String pw, boolean isMentor) {
        this.id = id;
        this.fName = fName;
        this.email = email;
        this.pw = pw;
        this.mentor = isMentor;
        //id = user table length + 1;
    }

    public int getId() {
        return id;
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
        return mentor;
    }
}
