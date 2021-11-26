package org.example.console;

import org.springframework.stereotype.Component;

@Component("writer")
public class ConsoleWriter {

    public void toReport(String message) {
        System.out.print(message);
    }
}
