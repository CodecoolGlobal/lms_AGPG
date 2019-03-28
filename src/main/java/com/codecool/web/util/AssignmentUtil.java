package com.codecool.web.util;

import com.codecool.web.model.Assignment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssignmentUtil {

    public static List<Assignment> getAssignmentsList(Connection connection) throws SQLException {
        String sql = "SELECT * FROM assignments";
        List<Assignment> assignmentList = new ArrayList<>();

        try (Statement statement = connection.createStatement()
        ) {
            statement.executeQuery(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String id = resultSet.getString("assignment_id");
                String mentorId = resultSet.getString("mentor_id");
                String assignmentDate = resultSet.getString("assignment_id");
                String question = resultSet.getString("question");
                String maxPoints = resultSet.getString("max_point");
                String date = resultSet.getString("assignment_date");
                String published = resultSet.getString("published");

                assignmentList.add(new Assignment(Integer.parseInt(id), Integer.parseInt(mentorId),
                    null, Boolean.parseBoolean(published), question, Integer.parseInt(maxPoints)));
            }
        }
        return assignmentList;
    }

    public static void addAssignment(Connection connection, int assId, boolean published, Date date, String question,
                                     int max_point, int mentor_id) throws SQLException {

        String sql = "INSERT INTO assignments\n" +
            "(assignment_id, published, assignment_date, question, max_point, mentor_id)\n" +
            "VALUES(" + assId + ", " + published + ", NULL , '" + question + "', " + max_point + ", " + mentor_id + ");";


        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }

    }
}
