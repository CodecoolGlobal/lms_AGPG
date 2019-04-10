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

    public static List<User> ModifyUsersPresent(List<User> users, String[] presentIds) throws SQLException {
        if (presentIds == null){
            return users;
        }
        for (User user : users) {
            for (String id : presentIds){
                if (user.getId() == Integer.parseInt(id)){
                    user.setPresent(true);
                    break;
                }
            }
        }
        return users;
    }

    public static boolean isUserPresentwithDate(Connection connection, Date sqlDate, int userId) throws SQLException {
        String sql = "SELECT * FROM attendance WHERE date_att = ? AND user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setDate(1, sqlDate);
            statement.setInt(2, userId);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
    }

    public static void addAttendance(Connection connection, Date date, int userID) throws SQLException {

        String sql = "INSERT INTO attendance " +
            "(user_id, date_att) " +
            "VALUES(?, ?); ";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userID);
            statement.setDate(2, date);
            statement.executeUpdate();
        }
    }

    public static void removeAttendance(Connection connection, Date date, int userID) throws SQLException {

        String sql = "DELETE FROM attendance " +
            "WHERE user_id = ? AND date_att = ?; ";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userID);
            statement.setDate(2, date);
            statement.executeUpdate();
        }
    }
}
