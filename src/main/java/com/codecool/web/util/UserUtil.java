package com.codecool.web.util;

import com.codecool.web.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                users.add(new User(userName, email, userPassword, Boolean.valueOf(isMentor)));
            }
        }
        return users;
    }
}
