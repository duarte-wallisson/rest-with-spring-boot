package br.com.duarte.converters;

import lombok.val;

public class NumberConverter {
    public static Double convertToDouble(String strN) {
        return Double.parseDouble(strN);
    }

    public static Boolean isNumeric(String strN) {
        var result = false;
        if (strN != null) {
            val n = strN.replaceAll(",", ".");
            result = n.matches("[-+]?[0-9]*\\.?[0-9]+");
        }
        return result;
    }
}
