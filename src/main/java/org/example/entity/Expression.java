package org.example.entity;

public class Expression {
    private double num1;
    private double num2;
    private String operation;
    private double result;

    public Expression(double num1, double num2, String operation, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
    }

    public String toString() {
        return num1 + " " + operation + " " + num2 + " = " + result ;
    }
}