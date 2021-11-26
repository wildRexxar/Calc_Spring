package org.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Operation {
    private double num1;
    private double num2;
    private String operator;
    private double result;
    private int id;

    @Autowired
    public Operation() {
    }

    public Operation(double num1, double num2, String operator, double result, int id) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        this.result = result;
        this.id = id;
    }

    public Operation createOperation(double num1, double num2, double result, int id, String operator) {
        return new Operation(num1, num2, operator, result, id);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return num1 + " " + operator + " " + num2 + " = " + result;
    }
}