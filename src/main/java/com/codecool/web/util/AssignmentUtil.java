package com.codecool.web.util;

import com.codecool.web.model.Assignment;
import com.codecool.web.model.User;

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

    public static void addAssignment(Connection connection, boolean published, Date date, String question,
                                     int max_point, int mentor_id) throws SQLException {

        String sql = "INSERT INTO assignments\n" +
            "(assignment_id, published, assignment_date, question, max_point, mentor_id)\n" +
            "VALUES(" + ", " + published + ", NULL , '" + question + "', " + max_point + ", " + mentor_id + ");";


        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }
}
