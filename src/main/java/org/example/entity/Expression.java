package org.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Expression {
    private double num1;
    private double num2;
    private String operation;
    private double result;
    private int id;

    @Autowired
    public Expression() {
    }

    private Expression(double num1, double num2, String operation, double result, int id) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
        this.id = id;
    }

    public Expression createExpression(double num1, double num2, String operation, double result, int id) {
        return new Expression(num1, num2, operation, result, id);
    }

    public String toString() {
        return num1 + " " + operation + " " + num2 + " = " + result + "\n";
    }

    public int getId() {
        return id;
    }
}