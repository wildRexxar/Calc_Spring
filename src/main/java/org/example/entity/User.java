package org.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
    private String login;
    private String password;
    private int id;

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

    public void setLogin(String login) {
        this.id = login.hashCode();
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String login) {
        this.id = login.hashCode();
    }

    public int getId() {
        return id;
    }

    public User createUser(String login, String password) {
        return new User(login, password);
    }
}