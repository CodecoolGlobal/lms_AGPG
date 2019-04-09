package com.codecool.web.util;

import com.codecool.web.model.Answer;

import java.sql.*;

public class AnswerUtil {

    //Inserts Name to users table
    public static void insertName(Connection connection) throws SQLException {
        //String sql = "SELECT * FROM cities";
        String sql = "INSERT INTO users (user_id, user_name, email, user_password, isMentor) VALUES "+
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
    
    public static void addAnswer(Connection connection, int assignmentId, int studentId, String answer) throws  SQLException {
        String sql = "INSERT INTO answers (assignment_id, student_id, answer, grade) VALUES (?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, assignmentId);
            statement.setInt(2, studentId);
            statement.setString(3, answer);
            statement.setInt(4, 0);
            statement.executeUpdate();
        }
    }

    public static void grade(Connection connection, int assignmentId, int grade) throws SQLException {
        String sql = "UPDATE answers SET grade = " + grade + "WHERE assignment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, assignmentId);
            statement.executeUpdate();
        }
    }

    public static Answer getAnswerByStudentId(Connection connection, int studentId) throws SQLException {
        String sql = "SELECT * FROM answers WHERE studentId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, studentId);
            statement.executeQuery(sql);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return new Answer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
        }
    }
    
    public static int getStudentIdByAssignmentId(Connection connection, int assignmentId) throws  SQLException{
        String sql = "SELECT student_id FROM answers WHERE assignmentId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, assignmentId);
            statement.executeQuery(sql);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(2);
        }
    }
}
