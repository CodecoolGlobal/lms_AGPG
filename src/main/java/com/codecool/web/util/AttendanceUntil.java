package com.codecool.web.util;


import java.sql.*;


public class AttendanceUntil {

    public static boolean isPresent(Connection connection, Date date, int userId) throws SQLException {

        String sql = "SELECT * FROM attendance WHERE user_id = ? AND date_att = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, userId);
            statement.setDate(2, date);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getBoolean(3);
        }
    }


}
