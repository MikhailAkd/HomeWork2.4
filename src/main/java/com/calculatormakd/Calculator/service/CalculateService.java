package com.calculatormakd.Calculator.service;

import com.calculatormakd.Calculator.exceptions.DivisionZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {

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
        if (num2 == 0) {
            throw new DivisionZeroException();
        }
        return (float) num1 / num2;
    }
}
