package org.example.controller;

import org.example.controller.console.Reader;
import org.example.controller.console.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("accountMenuController")
public class AccountMenuController {
    private final CalcController calcController;
    private final ResultController resultController;
    private final Reader reader;
    private final Writer writer;
    private String choice;

    @Autowired
    public AccountMenuController (CalcController calcController, ResultController resultController, Reader reader, Writer writer){
        this.calcController = calcController;
        this.resultController = resultController;
        this.reader = reader;
        this.writer = writer;
    }

    public void run() {
        writer.toReport("1 : Calculator\n");
        writer.toReport("2 : History\n");
        writer.toReport("3 : Exit\n");
        choice = reader.scanner();
        if (choice.equals("1")) {
            calcController.run();
        }
        if (choice.equals("2")) {
            resultController.run();
        }
        if (choice.equals("3")){
            System.exit(0);
        }
        else {
            run();
        }
    }
}