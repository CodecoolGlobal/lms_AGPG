package com.codecool.web.util;

import com.codecool.web.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    public static List<User> getUsers(Connection connection) throws SQLException {
        String sql = "SELECT user_id, user_name, email, user_password, ismentor FROM users";
        List<User> users = new ArrayList<>();
        try (Statement statement = connection.createStatement()
        ) {
            statement.executeQuery(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String id = String.valueOf(resultSet.getInt("user_id"));
                String userName = resultSet.getString("user_name");
                String email = resultSet.getString("email");
                String userPassword = resultSet.getString("user_password");
                String isMentor = String.valueOf(resultSet.getBoolean("ismentor"));
                users.add(new User(Integer.valueOf(id), userName, email, userPassword, Boolean.valueOf(isMentor)));
            }
        }
        return users;
    }

    public static void createUser(Connection connection, User user) throws SQLException {

        String sql = "INSERT INTO users " +
            "(user_name, email, user_password, ismentor) " +
            "VALUES(?, ?, ?, ?); ";

//        String sql = "INSERT INTO users " +
//            "(user_name, email, user_password, ismentor) " +
//            "VALUES(?, ?, crypt(?, gen_salt('bf', 9)) , ?); ";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getfName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPw());
            statement.setBoolean(4, user.isMentor());
            statement.executeUpdate();
        }
    }

    public static boolean isEmailUsed(Connection connection, String email) throws SQLException {
        String sql = "SELECT email FROM users WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
    }

    public static boolean isRegistrated(Connection connection, String email, String password) throws SQLException {

        String sql = "SELECT email FROM users WHERE email = ? AND user_password = ?";

//        String sql = "SELECT email FROM users WHERE email = ? AND user_password = crypt(?,user_password) ;";

        try (PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
    }


    public static User findUserByEmail(Connection connection, String email) throws SQLException {

        String sql = "SELECT * FROM users WHERE email = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            rs.next();

            //User(int id, String fName, String email, String pw, boolean isMentor) {
            return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5));
        }
    }

    public static void Update(Connection connection, User user, String columnName, String newValue) throws SQLException {

        String sql = "UPDATE users SET "+  columnName +" = ? WHERE email = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, newValue);
            statement.setString(2, user.getEmail());

            statement.executeUpdate();

        }
    }

    //Method overload
    public static void Update(Connection connection, User user, String columnName, boolean newValue) throws SQLException {

        String sql = "UPDATE users SET "+  columnName +" = ? WHERE email = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setBoolean(1, newValue);
            statement.setString(2, user.getEmail());

            statement.executeUpdate();

        }
    }
}
