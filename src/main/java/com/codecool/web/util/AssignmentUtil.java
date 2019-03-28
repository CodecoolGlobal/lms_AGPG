package com.codecool.web.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class AssignmentUtil {
    //Inserts Name to users table
    public static String getAssId(Connection connection) throws SQLException {
        String sql = "SELECT COUNT(assignment_id) FROM assignment";
        String s = "";
        try (Statement statement = connection.createStatement()) {
            statement.executeQuery(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                s = resultSet.getString("assignment_id");
            }
        }
        return s;
    }

    public static void addAssignment(Connection connection, int assId, boolean published, Date date, String question, int max_point, int mentor_id) throws SQLException {

        String sql = "INSERT INTO assignments\n" +
            "(assignment_id, published, assignment_date, question, max_point, mentor_id)\n" +
            "VALUES(" + assId + ", " + published + ", NULL , '" + question + "', " + max_point + ", " + mentor_id + ");";


        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }
}

