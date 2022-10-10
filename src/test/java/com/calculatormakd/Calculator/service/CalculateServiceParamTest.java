package com.calculatormakd.Calculator.service;

import net.minidev.json.JSONNavi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.calculatormakd.Calculator.service.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculateServiceParamTest {

    private final CalculateService calculateService = new CalculateService();

    @ParameterizedTest
    @MethodSource("calculateParams")
    public void shouldAmountCorrectly(int a, int b) {
        int result = calculateService.amount(a, b);
        assertEquals(a + b, result);
    }

    @ParameterizedTest
    @MethodSource("calculateParams")
    public void shouldDifferenceCorrectly(int a, int b) {
        int result = calculateService.difference(a, b);
        assertEquals(a - b, result);
    }

    @ParameterizedTest
    @MethodSource("calculateParams")
    public void shouldProductCorrectly(int a, int b) {
        int result = calculateService.product(a, b);
        assertEquals(a * b, result);
    }

    @ParameterizedTest
    @MethodSource("calculateParams")
    public void shouldQuotientCorrectly(int a, int b) {
        double result = calculateService.quotient(a, b);
        assertEquals(a / b, result);
    }

    private static Stream<Arguments> calculateParams() {
        return Stream.of(
                Arguments.of(TWO, ONE),
                Arguments.of(THREE, THREE),
                Arguments.of(ZERO, ONE)
        );
    }
}