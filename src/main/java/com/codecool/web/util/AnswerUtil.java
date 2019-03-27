package com.codecool.web.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnswerUtil {

    //Inserts Name to users table
    public static void insertName(Connection connection) throws SQLException {
        //String sql = "SELECT * FROM cities";
        String sql = "INSERT INTO users (user_id, user_name, email, user_password, isMentor) VALUES "+
            "(123, 'Test Elemes','hmm@article13', 'what', true);";
        String s = "";
        try (Statement statement = connection.createStatement();
        ) {
            statement.executeQuery(sql);
            //ResultSet resultSet = statement.executeQuery(sql)) {
           /* while (resultSet.next()) {
                s = resultSet.getString("name");
            }*/
        }
    }
}
