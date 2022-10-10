package com.calculatormakd.Calculator.service;

import com.calculatormakd.Calculator.exceptions.DivisionZeroException;
import org.junit.jupiter.api.Test;

import static com.calculatormakd.Calculator.service.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    public final CalculateService calculateService = new CalculateService();

    @Test
    public void amountOneAndOne() {
        int result = calculateService.amount(ONE, ONE);
        assertEquals(ONE + ONE, result);
    }

    @Test
    public void amountOneAndTwo() {
        int result = calculateService.amount(ONE, TWO);
        assertEquals(ONE + TWO, result);
    }

    @Test
    public void differenceThreeAndOne() {
        int result = calculateService.difference(THREE, ONE);
        assertEquals(THREE - ONE, result);
    }

    @Test
    public void differenceOneAndTwo() {
        int result = calculateService.difference(ONE, TWO);
        assertEquals(ONE - TWO, result);
    }

    @Test
    public void productThreeAndTwo() {
        int result = calculateService.product(THREE, TWO);
        assertEquals(THREE * TWO, result);
    }

    @Test
    public void productOneAndOne() {
        int result = calculateService.product(ONE, ONE);
        assertEquals(ONE * ONE, result);
    }

    @Test
    public void quotientThreeAndThree() {
        double result = calculateService.quotient(THREE, THREE);
        assertEquals(THREE / THREE, result);
    }

    @Test
    public void quotientOneAndOne() {
        double result = calculateService.quotient(ONE, ONE);
        assertEquals(ONE / ONE, result);
    }

    @Test
    public void divisionZeroException() {
        assertThrows(DivisionZeroException.class, () -> calculateService.quotient(ONE, ZERO));
    }
}