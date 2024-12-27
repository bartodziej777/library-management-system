package com.example.librarymanagementsystem.Models;

import com.example.librarymanagementsystem.Enums.Status;

import java.util.ArrayList;
import java.util.List;

public class UserService extends Entity {
    private final static List<User> users = new ArrayList<>(loadDefaultUsers());

    public UserService() {
        super("user service", Status.ACTIVE);
    }

    public static User authenticate(String login, String password) {
        for (User user : users) {
            if (user.getName().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    //loading predefined users enabling program demonstrations
    private static List<User> loadDefaultUsers() {
        List<User> defaultUsers = new ArrayList<>();
        defaultUsers.add(new Reader("student1", "1234"));
        defaultUsers.add(new Reader("student2", "qwer"));
        defaultUsers.add(new Librarian("john", "5678"));
        defaultUsers.add(new Librarian("mark", "asdf"));
        return defaultUsers;
    }
}
