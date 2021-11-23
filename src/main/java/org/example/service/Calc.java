package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("calc")
public class Calc {
    private final NumProcessing numProcessing;
    private double num1;
    private double num2;

    @Autowired
    public Calc(NumProcessing numProcessing) {
        this.numProcessing = numProcessing;
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

    public double getNum1() {
        num1 = numProcessing.getNum();
        return num1;
    }

    public double getNum2() {
        num2 = numProcessing.getNum();
        return num2;
    }
}