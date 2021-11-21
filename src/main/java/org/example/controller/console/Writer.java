package org.example.controller.console;

import org.springframework.stereotype.Component;

@Component("writer")
public class Writer {

    public void toReport(String message){
        System.out.print(message);
    }
}
