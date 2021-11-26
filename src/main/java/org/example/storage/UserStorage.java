package org.example.storage;

import org.example.entity.User;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class UserStorage {
    private ArrayList<User> usersList = new ArrayList<>();

    public boolean saveUser(User user) {
        return usersList.add(user);
    }

    public boolean checkLogin(String login) {
        for (User user : usersList) {
            if (user.getLogin().equals(login)) {
                return false;
            }
        }
        return true;
    }

    public boolean findUserByLoginAndPassword(String login, String password) {
        for (User user : usersList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
