package br.com.duarte.controllers;

import br.com.duarte.converters.NumberConverter;
import br.com.duarte.exceptions.UnsupportedMathOperationException;
import br.com.duarte.math.Calculator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();
    private final List<String> operations = new ArrayList<>();

    @RequestMapping("/{op}/{n1}/{n2}")
    public Double calc(@PathVariable(name = "op") String op, @PathVariable(name = "n1") String n1, @PathVariable(name = "n2") String n2) {
        if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
            throw new UnsupportedMathOperationException("Por favor, insira um valor numérico");
        }
        var dN1 = NumberConverter.convertToDouble(n1);
        var dN2 = NumberConverter.convertToDouble(n2);
        return Calculator.calcule(op, dN1, dN2);
    }
}
