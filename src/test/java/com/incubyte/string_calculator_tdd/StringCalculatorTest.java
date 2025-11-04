package com.incubyte.string_calculator_tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    // Step 1: Empty string and simple cases
    @Test
    void testEmptyStringReturnsZero() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void testSingleNumberReturnsTheNumber() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    void testTwoNumbersReturnTheirSum() {
        assertEquals(6, calculator.add("1,5"));
    }

    // Step 2: Any amount of numbers
    @Test
    void testMultipleNumbersReturnTheirSum() {
        assertEquals(10, calculator.add("1,2,3,4"));
    }

    @Test
    void testManyNumbersReturnTheirSum() {
        assertEquals(15, calculator.add("1,2,3,4,5"));
    }

    // Step 3: New line support
    @Test
    void testNewLinesBetweenNumbers() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    void testMixedDelimiters() {
        assertEquals(10, calculator.add("1\n2\n3,4"));
    }

    // Step 4: Custom delimiters
    @Test
    void testCustomDelimiterSemicolon() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    void testCustomDelimiterPipe() {
        assertEquals(15, calculator.add("//|\n1|2|3|4|5"));
    }

    @Test
    void testCustomDelimiterAsterisk() {
        assertEquals(6, calculator.add("//*\n1*2*3"));
    }

    // Step 5: Negative numbers validation
    @Test
    void testNegativeNumberThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3");
        });

        assertTrue(exception.getMessage().contains("negative numbers not allowed"));
        assertTrue(exception.getMessage().contains("-2"));
    }

    @Test
    void testMultipleNegativeNumbersShowAllInException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,-3,4,-5");
        });

        String message = exception.getMessage();
        assertTrue(message.contains("negative numbers not allowed"));
        assertTrue(message.contains("-2"));
        assertTrue(message.contains("-3"));
        assertTrue(message.contains("-5"));
    }

    @Test
    void testNegativeNumberWithCustomDelimiter() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("//;\n1;-2;3");
        });

        assertTrue(exception.getMessage().contains("negative numbers not allowed"));
        assertTrue(exception.getMessage().contains("-2"));
    }
}
