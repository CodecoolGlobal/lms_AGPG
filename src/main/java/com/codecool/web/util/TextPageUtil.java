package com.codecool.web.util;

import com.codecool.web.model.TextPage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TextPageUtil {

    public static List<TextPage> getTextPages(Connection connection) throws SQLException {
        List<TextPage> textPageList = new ArrayList<>();
        String sql = "SELECT * FROM textpage;";
        try (Statement statement = connection.createStatement()) {

            statement.executeQuery(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                boolean isPublished = resultSet.getBoolean("ispublished");
                java.sql.Date textPageDate = resultSet.getDate("date_created");
                String textTitle = resultSet.getString("textpage_title");
                String textValue = resultSet.getString("textpage_value");
                textPageList.add(new TextPage(textTitle, textValue, textPageDate, isPublished));
            }
        }
        return textPageList;
    }

    public static void addTextPage(Connection connection, boolean isPublished, String textTitle, String textValue) throws SQLException {

        long time = System.currentTimeMillis();
        java.sql.Date textPageDate = new java.sql.Date(time);
        String sql = "INSERT INTO textpage (textpage_title, textpage_value, date_created, ispublished) VALUES(?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, textTitle);
            statement.setString(2, textValue);
            statement.setDate(3, textPageDate);
            statement.setBoolean(4, isPublished);
            statement.executeUpdate();
        }
    }

}
