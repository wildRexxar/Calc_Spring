package org.example.console;

import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component("reader")
public class ConsoleReader {
    Scanner scanner;

    public ConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String scannerString() {
        return scanner.next();
    }
}