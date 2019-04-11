package com.codecool.web.util;

import com.codecool.web.model.Assignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AssignmentUtil {
    //Inserts Name to users table
    public static List<Assignment> getAssignments(Connection connection) throws SQLException {
        List<Assignment> assignmentList = new ArrayList<>();
        String sql = "SELECT * FROM assignments";
        try (Statement statement = connection.createStatement()) {

            statement.executeQuery(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("assignment_id");
                boolean published = resultSet.getBoolean("published");
                Date assignmentDate = resultSet.getDate("assignment_date");
                String question = resultSet.getString("question");
                int maxPoints = resultSet.getInt("max_point");
                int mentorId = resultSet.getInt("mentor_id");
                //    public Assignment(int assignmentId, boolean published, Date date, String question, int maxPoints,int mentorID) {
                assignmentList.add(new Assignment(id,published,assignmentDate,question,maxPoints,mentorId));
            }
        }
        return assignmentList;
    }

    public static Assignment getAssignmentById(Connection connection, int id) throws SQLException {
        Assignment assignment = null;
        String sql = "SELECT * FROM assignments WHERE assignment_id = " + id;
        try (Statement statement = connection.createStatement()) {
            statement.executeQuery(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id2 = resultSet.getInt("assignment_id");
                boolean published = resultSet.getBoolean("published");
                Date assignmentDate = resultSet.getDate("assignment_date");
                String question = resultSet.getString("question");
                int maxPoints = resultSet.getInt("max_point");
                int mentorId = resultSet.getInt("mentor_id");
                assignment = new Assignment(id2, published, assignmentDate, question, maxPoints, mentorId);
            }
        }
        if (assignment == null) {
            throw new SQLException("if u see this, something really bad happened");
        }
        return assignment;
    }


    public static void addAssignment(Connection connection, boolean published, String question,
                                     int max_point, int mentor_id) throws SQLException {

        String sql = "INSERT INTO assignments " +
            "(published, question, max_point, mentor_id) " +
            "VALUES(?, ?, ?, ?); ";


        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, published);
            statement.setString(2, question);
            statement.setInt(3, max_point);
            statement.setInt(4, mentor_id);
            statement.executeUpdate();
        }
    }
}
