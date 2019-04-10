package com.codecool.web.model;


public class User {
    private String fName;
    private String email;
    private String pw;
    private boolean isMentor;
    private int id;
    private boolean isPresent;

    public User(String fName, String email, String pw, boolean isMentor) {
        this.fName = fName;
        this.email = email;
        this.pw = pw;
        this.isMentor = isMentor;
    }

    public User(int id, String fName, String email, String pw, boolean isMentor) {
        this.id = id;
        this.fName = fName;
        this.email = email;
        this.pw = pw;
        this.isMentor = isMentor;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setMentor(boolean mentor) {
        isMentor = mentor;
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

    public int getId() {
        return id;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
