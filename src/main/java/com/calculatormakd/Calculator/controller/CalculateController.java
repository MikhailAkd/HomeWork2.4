package com.calculatormakd.Calculator.controller;

import com.calculatormakd.Calculator.exceptions.DivisionZeroException;
import com.calculatormakd.Calculator.service.CalculateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class CalculateController {
    private final CalculateService calculateService;

    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping
    public String hello() {
        return "<b>Добро пожаловать в калькулятор</b>";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer num1, @RequestParam(value = "num2", required = false) Integer num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)) {
            return "Необходимо ввести оба числа";
        }
        return resultOfCalculations(num1, num2, calculateService.amount(num1, num2), " + ");
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer num1, @RequestParam(value = "num2", required = false) Integer num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)) {
            return "Необходимо ввести оба числа";
        }
        return resultOfCalculations(num1, num2, calculateService.difference(num1, num2), " - ");
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer num1, @RequestParam(value = "num2", required = false) Integer num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)) {
            return "Необходимо ввести оба числа";
        }
        return resultOfCalculations(num1, num2, calculateService.product(num1, num2), " * ");
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer num1, @RequestParam(value = "num2", required = false) Integer num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)) {
            return "Необходимо ввести оба числа";
        }
        return resultOfCalculations(num1, num2, calculateService.quotient(num1, num2), " / ");
    }

    private String resultOfCalculations(int num1, int num2, Number result, String calculations) {
        return String.format("%d %s %d = %s", num1, calculations, num2, result, toString());
    }
}
