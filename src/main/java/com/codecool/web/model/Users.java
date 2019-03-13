package com.codecool.web.model;

public class Users {
    private static User[] users;

    public static User[] getUsers() {
        return users;
    }

    public static void setUsers(User[] users) {
        Users.users = users;
    }
}
