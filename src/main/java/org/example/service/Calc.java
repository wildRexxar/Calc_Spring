package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("calc")
public class Calc {
    private final NumProcessing numProcessing;
    private double num1;
    private double num2;

    @Autowired
    public Calc(NumProcessing numProcessing){
        this.numProcessing = numProcessing;
    }

    public double plus(){
        numInit();
        return num1 + num2;
    }

    public double minus(){
        numInit();
        return num1 - num2;
    }

    public double div() {
        numInit();
        return num1 / num2;
    }

    public double multi(){
        numInit();
        return num1 * num2;
    }

    private void numInit() {
        num1 = numProcessing.getNum();
        num2 = numProcessing.getNum();
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }
}