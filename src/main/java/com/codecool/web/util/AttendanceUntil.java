package com.codecool.web.util;

import com.codecool.web.model.User;

import java.sql.*;


public class AttendanceUntil {

    public static boolean isDateUsed(Connection connection, Date date) throws SQLException {

        String sql = "SELECT * FROM attendance WHERE date_att = ? GROUP BY date_att";


        try (PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setDate(1, date);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
    }
}
