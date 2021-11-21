package org.example.service;

import org.example.controller.console.Reader;
import org.example.controller.console.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("numProcessing")
public class NumProcessing {
    private String number;
    private final Reader reader;
    private final Writer writer;

    @Autowired
    public NumProcessing(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    private boolean checkNumber () {
        number = reader.scanner();
        return (number.matches("(-|\\+)?\\d+"));
    }

    public double getNum() {
        writer.toReport("Enter the number:\n");
        if (checkNumber() == false) {
            writer.toReport("Error. Repeat. \n");
            getNum();
        }
        return Double.parseDouble(number);
    }
}