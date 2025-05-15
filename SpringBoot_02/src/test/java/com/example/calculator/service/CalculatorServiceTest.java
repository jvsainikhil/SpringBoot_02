package com.example.calculator.service;

import org.junit.jupiter.api.Test;

import com.example.calculator.controller.CalculatorService;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private final CalculatorService service = new CalculatorService();

    @Test
    void testAdd() {
        assertEquals(5.0, service.add(2.0, 3.0));
    }

    @Test
    void testSubtract() {
        assertEquals(1.0, service.subtract(4.0, 3.0));
    }

    @Test
    void testMultiply() {
        assertEquals(6.0, service.multiply(2.0, 3.0));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, service.divide(6.0, 3.0));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> service.divide(5.0, 0.0));
    }
}
