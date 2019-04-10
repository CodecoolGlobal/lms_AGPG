package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public class Statistic {

    private String fullName;
    private int userId;
    private List<Integer> gradesList;

    public Statistic(String fullName, int userId, List<Integer> gradesList) {
        this.fullName = fullName;
        this.userId = userId;
        this.gradesList = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public int getUserId() {
        return userId;
    }

    public List<Integer> getGradesList() {
        return gradesList;
    }
}
