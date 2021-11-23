package org.example.storage;

import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UsersStorage {
    private ArrayList<User> usersList;

    @Autowired
    public UsersStorage(ArrayList<User> usersList) {
        this.usersList = usersList;
    }

    public void saveUser(User user) {
        usersList.add(user);
    }

    public boolean checkLogin(String login) {
        for (User user : usersList) {
            if (user.getLogin().equals(login)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkLoginAndPassword(String login, String password) {
        for (User user : usersList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
