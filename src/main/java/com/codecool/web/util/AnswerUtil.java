package com.codecool.web.util;

import com.codecool.web.model.Answer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnswerUtil {

    //Inserts Name to users table
    public static void insertName(Connection connection) throws SQLException {
        //String sql = "SELECT * FROM cities";
        String sql = "INSERT INTO users (user_id, user_name, email, user_password, isMentor) VALUES " +
            "(123, 'Test Elemes','hmm@article13', 'what', true);";
        String s = "";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            //ResultSet resultSet = statement.executeQuery(sql)) {
           /* while (resultSet.next()) {
                s = resultSet.getString("name");
            }*/
        }
    }

    public static void addAnswer(Connection connection, int assignmentId, int studentId, String answer) throws SQLException {
        String sql = "INSERT INTO answers (assignment_id, student_id, answer, grade) VALUES (?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, assignmentId);
            statement.setInt(2, studentId);
            statement.setString(3, answer);
            statement.setInt(4, 0);
            statement.executeUpdate();
        }
    }

    public static void grade(Connection connection, int assignmentId, int studentId , int grade) throws SQLException {
        String sql = "UPDATE answers SET grade = ? WHERE answers.assignment_id = ? AND student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, grade);
            statement.setInt(2, assignmentId);
            statement.setInt(3, studentId);
            statement.executeUpdate();
        }
    }

    public static List<Answer> getAnswerList(Connection connection, int assignmentId) throws SQLException {
        List<Answer> answerList = new ArrayList<>();
        String sql = "SELECT * FROM answers WHERE assignment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, assignmentId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                answerList.add(new Answer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4)));
            }
            return answerList;
        }
    }

    public static Answer getAnswerByStudentId(Connection connection, int studentId) throws SQLException {
        String sql = "SELECT * FROM answers WHERE student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, studentId);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return new Answer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
        }
    }

    public static int getStudentIdByAssignmentId(Connection connection, int assignmentId) throws SQLException {
        String sql = "SELECT student_id FROM answers WHERE answers.assignment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, assignmentId);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }
    
    public static boolean isAnswered(Connection connection, int assignmentId, int studentId) throws SQLException {
        String sql = "SELECT assignment_id, student_id FROM answers WHERE assignment_id = ? AND student_id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, assignmentId);
            statement.setInt(2, studentId);
            ResultSet rs = statement.executeQuery();
            return rs.next();
        }
    }
}

