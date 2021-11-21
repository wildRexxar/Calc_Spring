package org.example.storage;

import org.example.controller.console.Writer;
import org.example.entity.Expression;
import org.springframework.stereotype.Component;
import java.util.List;

@Component("resultStorage")
public class ResultsStorage {
    private static List<Expression> listOfResults;
    private final Writer writer;

    public ResultsStorage(List<Expression> listOfResults, Writer writer) {
        this.listOfResults = listOfResults;
        this.writer = writer;
    }

    public void add (double num1, String operation, double num2, double result) {
        listOfResults.add(new Expression(num1, num2, operation, result));
    }

    public void get () {
        for(Expression arr : listOfResults) {
            writer.toReport(arr.toString() + "\n");
        }
    }
}