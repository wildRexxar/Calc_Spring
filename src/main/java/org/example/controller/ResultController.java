package org.example.controller;

import org.example.controller.console.Reader;
import org.example.controller.console.Writer;
import org.example.storage.ResultsStorage;
import org.springframework.stereotype.Component;

@Component("resultController")
public class ResultController {
    private final Reader reader;
    private final Writer writer;
    private final ResultsStorage resultsStorage;
    private String choice;

    ResultController (Reader reader, Writer writer, ResultsStorage resultsStorage) {
        this.reader = reader;
        this.writer = writer;
        this.resultsStorage = resultsStorage;
    }

    public void run(){
        writer.toReport("1 : Get results history\n");
        writer.toReport("2 : Delete results history\n");
        writer.toReport("3 : Back to menu\n");
        choice = reader.scanner();
        if(choice.equals("1")) {
            resultsStorage.get();
            run();
        }
        if(choice.equals("2")) {
            resultsStorage.clear();
            run();
        }
        if(choice.equals("3")) {
//            accountMenuController.run();
        }
        else {
            run();
        }
    }
}
