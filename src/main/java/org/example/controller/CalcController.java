package org.example.controller;

import org.example.controller.console.Reader;
import org.example.controller.console.Writer;
import org.example.service.Calc;
import org.example.storage.ResultsStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("calcController")
public class CalcController {
    private final Reader reader;
    private final Writer writer;
    private final Calc calc;
    private final ResultsStorage resultsStorage;
    private double result;
    private String operation;

    @Autowired
    public CalcController(Reader reader, Writer writer, Calc calc, ResultsStorage resultsStorage) {
        this.reader = reader;
        this.writer = writer;
        this.calc = calc;
        this.resultsStorage = resultsStorage;
    }

    public void run() {
        do {
            writer.toReport("Choose action:\n");
            writer.toReport("+\n");
            writer.toReport("-\n");
            writer.toReport("*\n");
            writer.toReport("/\n");
            writer.toReport("0 : Back to menu\n");
            operation = reader.scanner();

            switch (operation) {
                case "+": {
                    result = calc.plus();
                    writer.toReport(Double.toString(result)+"\n");
                    sendResultToStorage();
                    break;
                }
                case "-": {
                    result = calc.minus();
                    writer.toReport(Double.toString(result)+"\n");
                    sendResultToStorage();
                    break;
                }
                case "*": {
                    result = calc.multi();
                    writer.toReport(Double.toString(result)+"\n");
                    sendResultToStorage();
                    break;
                }
                case "/": {
                    result = calc.div();
                    writer.toReport(Double.toString(result)+"\n");
                    sendResultToStorage();
                    break;
                }
                case "0": {
//                    accountMenuController.run();
                }
                default: {
                    run();
                }
            }
        } while (true);
    }
    private void sendResultToStorage() {
        resultsStorage.add(calc.getNum1(), operation, calc.getNum2(), result);
    }
}