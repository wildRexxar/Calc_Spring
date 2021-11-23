package org.example.controller;

import org.example.controller.console.Reader;
import org.example.controller.console.Writer;
import org.example.entity.Expression;
import org.example.entity.User;
import org.example.service.Calc;
import org.example.storage.OperationsStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMenu {
    private final Calc calc;
    private final Expression expression;
    private final Writer writer;
    private final Reader reader;
    private final OperationsStorage operationsStorage;
    private final Application application;
    private User user;
    private String operation;

    @Autowired
    public UserMenu(Calc calc, Expression expression, Writer writer, Reader reader, OperationsStorage operationsStorage, User user, Application application) {
        this.calc = calc;
        this.application = application;
        this.expression = expression;
        this.writer = writer;
        this.reader = reader;
        this.operationsStorage = operationsStorage;
        this.user = user;
    }

    public void run() {
        writer.toReport("Choose action\n");
        writer.toReport("1 - Calculator\n");
        writer.toReport("2 - History\n");
        writer.toReport("3 - Logout\n");
        operation = reader.scanner();
        if (operation.equals("1")) {
            calcAccess();
            run();
        }
        if (operation.equals("2")) {
            resultsHistoryAccessAccess();
            run();
        }
        if (operation.equals("3")) {
            application.run();
        } else {
            run();
        }
    }

    private void calcAccess() {
        writer.toReport("+\n");
        writer.toReport("-\n");
        writer.toReport("*\n");
        writer.toReport("/\n");
        writer.toReport("0 - Menu\n");
        operation = reader.scanner();

        if (operation.equals("+")) {
            Expression result = expression.createExpression(calc.getNum1(), calc.getNum2(), operation, calc.plus(), user.getId());
            saveAndPrintResult(result);
        }
        if (operation.equals("-")) {
            Expression result = expression.createExpression(calc.getNum1(), calc.getNum2(), operation, calc.minus(), user.getId());
            saveAndPrintResult(result);
        }
        if (operation.equals("*")) {
            Expression result = expression.createExpression(calc.getNum1(), calc.getNum2(), operation, calc.multi(), user.getId());
            saveAndPrintResult(result);
        }
        if (operation.equals("/")) {
            Expression result = expression.createExpression(calc.getNum1(), calc.getNum2(), operation, calc.div(), user.getId());
            saveAndPrintResult(result);
        }
        if (operation.equals("0")) {
            run();
        } else {
            calcAccess();
        }
    }

    private void saveAndPrintResult(Expression result) {
        operationsStorage.save(result);
        writer.toReport(result.toString());
        calcAccess();
    }

    private void resultsHistoryAccessAccess() {
        writer.toReport("1 - Get results history\n");
        writer.toReport("2 - Delete history\n");
        writer.toReport("3 - Exit\n");
        operation = reader.scanner();
        if (operation.equals("1")) {
            operationsStorage.get();
            resultsHistoryAccessAccess();
        }
        if (operation.equals("2")) {
            operationsStorage.clear();
            resultsHistoryAccessAccess();
        }
        if (operation.equals("3")) {
            run();
        }
    }
}