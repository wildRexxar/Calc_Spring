package org.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
    private String login;
    private String password;

    @Autowired
    public User() {
    }

    private User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public User createUser(String login, String password) {
        return new User(login, password);
    }
}