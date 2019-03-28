package com.codecool.web.model;

import java.util.Date;

public class Assignment {
    private int assignmentId;
    private int mentorID;
    private Date date;
    private boolean published;
    private String question;
    private int maxPoints;

    public Assignment(int assignmentId, boolean published, Date date, String question, int maxPoints,int mentorID) {
        this.assignmentId = assignmentId;
        this.published = published;
        this.date = date;
        this.question = question;
        this.maxPoints = maxPoints;
        this.mentorID = mentorID;

    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public int getMentorID() {
        return mentorID;
    }

    public Date getDate() {
        return date;
    }

    public boolean isPublished() {
        return published;
    }

    public String getQuestion() {
        return question;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setMentorID(int mentorID) {
        this.mentorID = mentorID;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }
}
