package org.example.controller.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("reader")
public class Reader {
    Scanner scanner;

    @Autowired
    public Reader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String scanner() {
        return scanner.next();
    }
}