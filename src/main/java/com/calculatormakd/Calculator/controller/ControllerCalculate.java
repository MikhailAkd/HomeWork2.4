package com.calculatormakd.Calculator.controller;

import com.calculatormakd.Calculator.service.ServiceCalculate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class ControllerCalculate {
    private final ServiceCalculate serviceCalculate;

    public ControllerCalculate(ServiceCalculate serviceCalculate) {
        this.serviceCalculate = serviceCalculate;
    }

    @GetMapping
    public String hello() {
        return "<b>Добро пожаловать в калькулятор</b>";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam (value = "num1", required = false) Integer num1, @RequestParam (value = "num2", required = false) Integer num2){
        if (Objects.isNull(num1) || Objects.isNull(num2)){
            return "Необходимо ввести оба числа";
        }
        return resultOfCalculations(num1, num2, serviceCalculate.amount(num1,num2), " + ");
    }

    @GetMapping("/minus")
    public String minus(@RequestParam (value = "num1", required = false) Integer num1, @RequestParam (value = "num2", required = false) Integer num2){
        if (Objects.isNull(num1) || Objects.isNull(num2)){
            return "Необходимо ввести оба числа";
        }
        return resultOfCalculations(num1, num2, serviceCalculate.difference(num1,num2), " - ");
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam (value = "num1", required = false) Integer num1, @RequestParam (value = "num2", required = false) Integer num2){
        if (Objects.isNull(num1) || Objects.isNull(num2)){
            return "Необходимо ввести оба числа";
        }
        return resultOfCalculations(num1, num2, serviceCalculate.product(num1,num2), " * ");
    }

    @GetMapping("/divide")
    public String divide(@RequestParam (value = "num1", required = false) Integer num1, @RequestParam (value = "num2", required = false) Integer num2){
        if (Objects.isNull(num1) || Objects.isNull(num2)){
            return "Необходимо ввести оба числа";
        }
        if (num2 == 0) {
            return "Нельзя делить на 0";
        }
        return resultOfCalculations(num1, num2, serviceCalculate.quotient(num1,num2), " / ");
    }

    private String resultOfCalculations(int num1, int num2, Number result, String calculations) {
        return String.format("%d %s %d = %s",num1, calculations, num2, result,toString());
    }
}
