package pro.sky.homeworkcalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetUser() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(name = "num1", required = false) Integer a,
                       @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Один из параметров не внесен!";
        }
        return a + " + " + b + " = " + calculatorService.plus(a, b);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer a,
                        @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Один из параметров не внесен!";
        }
        return a + " - " + b + " = " + calculatorService.minus(a, b);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "num1", required = false) Integer a,
                           @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Один из параметров не внесен!";
        }
        return a + " * " + b + " = " + calculatorService.multiply(a, b);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam(name = "num1", required = false) Integer a,
                         @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Один из параметров не внесен!";
        }
        if (b == 0) {
            return "В Java на 0 делить нельзя!";
        }
        return a + " / " + b + " = " + calculatorService.divide(a, b);
    }
}