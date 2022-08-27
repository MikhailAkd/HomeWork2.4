package com.calculatormakd.Calculator.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceCalculate {

    public int amount(int num1, int num2) {
        return num1 + num2;
    }

    public int difference(int num1, int num2) {
        return num1 - num2;
    }

    public int product(int num1, int num2) {
        return num1 * num2;
    }

    public double quotient(int num1, int num2) {
        return (float) num1 / num2;
    }

}
