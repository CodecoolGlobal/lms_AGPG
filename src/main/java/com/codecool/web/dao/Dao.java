package com.codecool.web.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    public static String getDao(Connection connection) throws SQLException {
        String sql = "SELECT * FROM cities";
        String s = "";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                s = resultSet.getString("name");
            }
        }
        return s;
    }
}
