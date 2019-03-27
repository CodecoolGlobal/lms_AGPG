package com.codecool.web.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AssignmentUtil {

    public static void insertName(Connection connection) throws SQLException {
        //String sql = "SELECT * FROM cities";
        String sql = "INSERT INTO users (user_id)" +
            "VALUES (6)";
        String s = "";
        try (Statement statement = connection.createStatement()
        ) {
            statement.executeQuery(sql);
            //ResultSet resultSet = statement.executeQuery(sql)) {
           /* while (resultSet.next()) {
                s = resultSet.getString("name");
            }*/
        }
    }
}
