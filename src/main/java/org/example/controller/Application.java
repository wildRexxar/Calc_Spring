package org.example.controller;

import org.example.controller.console.Reader;
import org.example.controller.console.Writer;
import org.example.entity.User;
import org.example.storage.UsersStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Application {
    private UserMenu userMenu;
    private final Writer writer;
    private final Reader reader;
    private final UsersStorage usersStorage;
    private final User user;
    private String operation;
    private String login;
    private String password;

    @Autowired
    public Application(Writer writer, Reader reader, UsersStorage usersStorage, User user) {
        this.writer = writer;
        this.reader = reader;
        this.usersStorage = usersStorage;
        this.user = user;
    }

    public void run() {
        writer.toReport("Choice action\n");
        writer.toReport("1 - Authorization\n");
        writer.toReport("2 - Registration\n");
        writer.toReport("3 - Exit\n");
        operation = reader.scanner();

        if (operation.equals("1")) {
            writer.toReport("Enter login\n");
            login = reader.scanner();
            writer.toReport("Enter password\n");
            password = reader.scanner();
            if (usersStorage.checkLoginAndPassword(login, password)) {
                user.setId(login);
                userMenu.run();
            } else {
                writer.toReport("Wrong login or password\n");
                run();
            }
        }

        if (operation.equals("2")) {
            writer.toReport("Enter login\n");
            login = reader.scanner();
            if (usersStorage.checkLogin(login)) {
                writer.toReport("Enter password\n");
                password = reader.scanner();
                usersStorage.saveUser(user.createUser(login, password));
                writer.toReport("Registration successful\n");
                run();
            } else {
                writer.toReport("Such user exist\n");
                run();
            }
        }
        if (operation.equals("3")) {
            System.exit(0);
        }
    }

    @Autowired
    public void setUserMenu(UserMenu userMenu) {
        this.userMenu = userMenu;
    }
}
