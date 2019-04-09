package com.codecool.web.util;


import com.codecool.web.model.User;

import java.sql.*;
import java.util.List;


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

    public static boolean isDateUsed(Connection connection, Date sqlDate) throws SQLException {
        String sql = "SELECT DISTINCT ON(date_att) * FROM attendance WHERE date_att = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setDate(1, sqlDate);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
    }

    public static List<User> setUsersPresent(Connection connection, Date sqlDate, List<User> users) throws SQLException {
        for (User user : users) {
            String sql = "SELECT * FROM attendance WHERE date_att = ? AND user_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)
            ) {
                statement.setDate(1, sqlDate);
                statement.setInt(2, user.getId());
                ResultSet resultSet = statement.executeQuery();
                user.setPresent(resultSet.next());
            }
        }
        return users;
    }


}
