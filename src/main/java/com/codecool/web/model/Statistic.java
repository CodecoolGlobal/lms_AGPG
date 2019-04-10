package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public class Statistic {

    private List<Integer> assignmentIdList;
    private List<String> questionsList;
    private List<String> answersList;
    private List<Integer> gradesList;

    public Statistic(List<Integer> assignmentIdList, List<String> questionsList, List<String> answersList, List<Integer> gradesList) {
        this.assignmentIdList = assignmentIdList;
        this.questionsList = questionsList;
        this.answersList = answersList;
        this.gradesList = gradesList;
    }

    public List<Integer> getAssignmentIdList() {
        return assignmentIdList;
    }

    public List<String> getQuestionsList() {
        return questionsList;
    }

    public List<String> getAnswersList() {
        return answersList;
    }

    public List<Integer> getGradesList() {
        return gradesList;
    }
}
