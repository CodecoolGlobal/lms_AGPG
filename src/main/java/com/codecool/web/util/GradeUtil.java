package com.codecool.web.util;

import com.codecool.web.model.Statistic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeUtil {

    public static Statistic getAnswersForLoggedInUser(Connection connection, int studentId) throws SQLException {
        List<Integer> gradesList = new ArrayList<>();
        List<String> questionsList = new ArrayList<>();
        List<String> answersList = new ArrayList<>();
        List<Integer> assignmentIdList = new ArrayList<>();


        String sql = "SELECT question, answers.assignment_id, answers.answer, answers.grade " +
            "FROM assignments " +
            "FULL JOIN answers " +
            "on assignments.assignment_id = answers.assignment_id " +
            "WHERE answers.student_id = ?;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int grade = resultSet.getInt("grade");
                gradesList.add(grade);
                String question = resultSet.getString("question");
                questionsList.add(question);
                String answer = resultSet.getString("answer");
                answersList.add(answer);
                int assignmentId = resultSet.getInt("assignment_id");
                assignmentIdList.add(assignmentId);
            }

            return new Statistic(assignmentIdList, questionsList, answersList, gradesList);
        }
    }
}
