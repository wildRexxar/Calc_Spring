package org.example.service;

import org.example.entity.User;
import org.example.storage.UserStorage;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private UserStorage userStorage;
    private User user;

    public UserService(UserStorage userStorage, User user) {
        this.userStorage = userStorage;
        this.user = user;
    }

    public boolean addUser(String login, String password) {
        return userStorage.saveUser(user.createUser(login, password));
    }

    public boolean checkLogin(String login) {
        return userStorage.checkLogin(login);
    }

    public boolean findUser(String login, String password) {
        return userStorage.findUserByLoginAndPassword(login, password);
    }
}
