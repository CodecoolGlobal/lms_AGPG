package com.codecool.web.service;

import com.codecool.web.model.User;

import javax.sql.rowset.spi.XmlReader;

public class ServletHelper {

     public static boolean isValidEmail(String user_email ,String path){
        User[] users = XMLparser.read(path);

        for (User user : users) {
            if (user.getEmail().equals(user_email)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRegistered(String user_email, String user_pass ,String path){
        User[] users = XMLparser.read(path);

        boolean isFind = false;
        for (User user : users) {
            if (user.getEmail().equals(user_email) && user.getPw().equals(user_pass)) {
                isFind = true;
            }
        }
        return isFind;
    }
}
