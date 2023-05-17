package br.com.duarte.math;

public class Calculator {
    public static Double calcule(String op, Double dN1, Double dN2) {
        return switch (op) {
            case "sum" -> dN1 + dN2;
            case "subtraction" -> dN1 - dN2;
            case "multiplication" -> dN1 * dN2;
            case "division" -> dN1 / dN2;
            default -> 0.0;
        };
    }
}
