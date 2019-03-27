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
        ArrayList<String> s = new ArrayList<>();
        List<User> users = new ArrayList<>();
        try (Statement statement = connection.createStatement()
        ) {
            statement.executeQuery(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                s.add(String.valueOf(resultSet.getInt("user_id")));
                s.add(resultSet.getString("user_name"));
                s.add(resultSet.getString("email"));
                s.add(resultSet.getString("user_password"));
                s.add(String.valueOf(resultSet.getBoolean("ismentor")));
                User getUserObject = new User(s.get(1), s.get(2), s.get(3), Boolean.valueOf(s.get(4)));
                users.add(getUserObject);
            }
        }
        return users;
    }
}
