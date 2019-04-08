package com.codecool.web.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "INSERT INTO answers (assignment_id, student_id, answer) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, assignmentId);
            statement.setInt(2, studentId);
            statement.setString(3, answer);
            statement.executeUpdate();
        }
    }
}
