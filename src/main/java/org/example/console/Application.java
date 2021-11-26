package org.example.console;

import org.example.service.CalcService;
import org.example.service.OperationService;
import org.example.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class Application {
    private final OperationService operationService;
    private final UserService userService;
    private final CalcService calcService;
    private final ConsoleWriter writerConsole;
    private final ConsoleReader readerConsole;
    private int id;

    public Application(OperationService operationService, UserService userService, CalcService calc, ConsoleWriter writer, ConsoleReader reader) {
        this.operationService = operationService;
        this.userService = userService;
        this.calcService = calc;
        this.writerConsole = writer;
        this.readerConsole = reader;
    }

    public void run() {
        String operator;
        boolean status = true;
        while (status) {
            writerConsole.toReport("Choice action\n");
            writerConsole.toReport("1 - Authorization\n");
            writerConsole.toReport("2 - Registration\n");
            writerConsole.toReport("3 - Exit\n");
            operator = readerConsole.scannerString();
            switch (operator) {
                case "1": {
                    authorization();
                    break;
                }
                case "2": {
                    registration();
                    break;
                }
                case "3": {
                    status = false;
                    break;
                }
                default: {
                    writerConsole.toReport("wrong command");
                }
            }
        }
    }

    private void authorization() {
        String login;
        String password;
        writerConsole.toReport("Enter login\n");
        login = readerConsole.scannerString();
        writerConsole.toReport("Enter password\n");
        password = readerConsole.scannerString();
        if (userService.findUser(login, password)) {
            id = login.hashCode();
            calcMenu();
        } else {
            writerConsole.toReport("Wrong login or password\n");
        }
    }

    private void registration() {
        String login;
        String password;
        writerConsole.toReport("Enter login\n");
        login = readerConsole.scannerString();
        if (userService.checkLogin(login)) {
            writerConsole.toReport("Enter password\n");
            password = readerConsole.scannerString();
            userService.addUser(login, password);
            writerConsole.toReport("Registration successful\n");
        } else {
            writerConsole.toReport("Such user exist\n");
        }
    }

    private void calcMenu() {
        String operator;
        boolean status = true;
        while (status) {
            writerConsole.toReport("Choose action\n");
            writerConsole.toReport("1 - Calculator\n");
            writerConsole.toReport("2 - History\n");
            writerConsole.toReport("3 - Logout\n");
            operator = readerConsole.scannerString();
            switch (operator) {
                case "1": {
                    calc();
                    break;
                }
                case "2": {
                    resultHistory();
                    break;
                }
                case "3": {
                    status = false;
                    break;
                }
                default: {
                    writerConsole.toReport("Wrong command\n");
                }
            }
        }
    }

    private void calc() {
        String operator;
        writerConsole.toReport("+\n");
        writerConsole.toReport("-\n");
        writerConsole.toReport("*\n");
        writerConsole.toReport("/\n");
        writerConsole.toReport("e - Menu\n");
        operator = readerConsole.scannerString();
        switch (operator) {
            case "+": {
                calcService.setNum1();
                calcService.setNum2();
                double result = calcService.plus();
                operationService.saveOperation(calcService.getNum1(), calcService.getNum2(), result, id, operator);
                writerConsole.toReport(calcService.getNum1() + " " + operator + " " + calcService.getNum2() + " = " + result + "\n");
                break;
            }
            case "-": {
                calcService.setNum1();
                calcService.setNum2();
                double result = calcService.minus();
                operationService.saveOperation(calcService.getNum1(), calcService.getNum2(), result, id, operator);
                writerConsole.toReport(calcService.getNum1() + " " + operator + " " + calcService.getNum2() + " = " + result + "\n");
                break;
            }
            case "*": {
                calcService.setNum1();
                calcService.setNum2();
                double result = calcService.multi();
                operationService.saveOperation(calcService.getNum1(), calcService.getNum2(), result, id, operator);
                writerConsole.toReport(calcService.getNum1() + " " + operator + " " + calcService.getNum2() + " = " + result + "\n");
                break;
            }
            case "/": {
                calcService.setNum1();
                calcService.setNum2();
                double result = calcService.div();
                operationService.saveOperation(calcService.getNum1(), calcService.getNum2(), result, id, operator);
                writerConsole.toReport(calcService.getNum1() + " " + operator + " " + calcService.getNum2() + " = " + result + "\n");
                break;
            }
            case "e": {
                calcMenu();
                break;
            }
            default: {
                writerConsole.toReport("wrong command\n");
            }
        }
    }

    private void resultHistory() {
        String operator;
        writerConsole.toReport("1 - Get results history\n");
        writerConsole.toReport("2 - Delete history\n");
        writerConsole.toReport("3 - Exit to menu\n");
        operator = readerConsole.scannerString();
        switch (operator) {
            case "1": {
                operationService.getOperation(id);
                break;
            }
            case "2": {
                operationService.deleteUserOperations(id);
                break;
            }
            case "3": {
                calcMenu();
                break;
            }
            default: {
                writerConsole.toReport("Wrong command\n");
            }
        }
    }
}