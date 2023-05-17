package br.com.duarte;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/sum/{n1}/{n2}")
    public Double sum(@PathVariable(name = "n1") String n1, @PathVariable(name = "n2") String n2) throws Exception {
        if(!isNumeric(n1) || !isNumeric(n2)) {
            throw new Exception();
        }
        return convertToDouble(n1) + convertToDouble(n2);
    }

    private Double convertToDouble(String strN) {
        return Double.parseDouble(strN);
    }

    private boolean isNumeric(String strN) {
        boolean result = false;
        if (strN != null) {
            String n = strN.replaceAll(",", ".");
            result = n.matches("[-+]?[0-9]*\\.?[0-9]+");
        }
        return result;
    }
}
