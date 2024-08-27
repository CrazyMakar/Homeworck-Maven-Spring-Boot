package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calculator")
@RestController
public class CalculatorController {

    private static final String mess = "один (оба) из параметров не определён(ы)";
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public Boolean verifiValue(Integer num1, Integer num2) {
        return (num1 == null || num2 == null);
    }

    @GetMapping
    public String calculator() {
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam(required = false) Integer num1,
                       @RequestParam(required = false) Integer num2) {
        if (verifiValue(num1, num2) == true) {
            return mess;
        } else {
            var result = calculatorService.plus(num1, num2);
            return num1 + " + " + num2 + " = " + result;
        }
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam(required = false) Integer num1,
                        @RequestParam(required = false) Integer num2) {
        if (verifiValue(num1, num2) == true) {
            return mess;
        } else {
            var result = calculatorService.minus(num1, num2);
            return num1 + " - " + num2 + " = " + result;
        }
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(required = false) Integer num1,
                           @RequestParam(required = false) Integer num2) {
        if (verifiValue(num1, num2) == true) {
            return mess;
        } else {
            var result = calculatorService.multiply(num1, num2);
            return num1 + " * " + num2 + " = " + result;
        }
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam(required = false) Integer num1,
                         @RequestParam(required = false) Integer num2) {
        if (verifiValue(num1, num2) == true) {
            return mess;
        }
        if (num2 == 0) {
            return "Делить на ноль нельзя!";
        }
        var result = calculatorService.divide(num1, num2);
        return num1 + " / " + num2 + " = " + result;
    }
}