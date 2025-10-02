package tiy.tmp.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public CalculatorService() {
        System.out.println("CalculatorService constructor");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}
