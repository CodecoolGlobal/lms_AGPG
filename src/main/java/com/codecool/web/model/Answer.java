package com.codecool.web.model;

public class Answer {
    private int assignmentId;
    private int studentId;
    private String answer;
    private int grade;
    
    public Answer(int assignmentId, int studentId, String answer, int grade) {
        this.assignmentId = assignmentId;
        this.studentId = studentId;
        this.answer = answer;
        this.grade = grade;
    }
    public int getAssignmentId() {
        return assignmentId;
    }
    
    public int getStudentId() {
        return studentId;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    public int getGrade() {
        return grade;
    }
    

}
