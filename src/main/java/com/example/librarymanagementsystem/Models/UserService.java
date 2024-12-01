package com.example.librarymanagementsystem.Models;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final static List<User> users = new ArrayList<>(loadDefaultUsers());

    public static User authenticate(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private static List<User> loadDefaultUsers() {
        List<User> defaultUsers = new ArrayList<>();
        defaultUsers.add(new Client("client", "1234"));
        defaultUsers.add(new Admin("admin", "1234"));
        return defaultUsers;
    }

    public static void ShowAllUsers() {
        System.out.println(users);
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

}
