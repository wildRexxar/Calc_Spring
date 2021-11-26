package org.example.service;

import org.example.console.ConsoleReader;
import org.example.console.ConsoleWriter;
import org.springframework.stereotype.Component;

@Component
public class CalcService {
    private double num1;
    private double num2;
    private final ConsoleWriter consoleWriter;
    private final ConsoleReader consoleReader;

    public CalcService(ConsoleWriter consoleWriter, ConsoleReader consoleReader) {
        this.consoleWriter = consoleWriter;
        this.consoleReader = consoleReader;
    }

    public double plus() {
        return num1 + num2;
    }

    public double minus() {
        return num1 - num2;
    }

    public double div() {
        return num1 / num2;
    }

    public double multi() {
        return num1 * num2;
    }

    private double numProcessing() {
        while (true) {
            consoleWriter.toReport("Enter num\n");
            String number = consoleReader.scannerString();
            if (number.matches("([-+])?\\d+")) {
                return Double.parseDouble(number);
            }
            consoleWriter.toReport("Wrong num. Repeat\n");
        }
    }

    public void setNum1() {
        this.num1 = numProcessing();
    }

    public void setNum2() {
        this.num2 = numProcessing();
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }
}