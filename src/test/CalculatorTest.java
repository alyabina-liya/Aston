package test;

import main.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void sumTest() {

        assertEquals(calculator.sum(5, 3), 8);
    }

    @Test
    void subtractTest() {
        assertEquals(calculator.subtract(5, 3), 2);
    }

    @Test
    void multiplyTest() {
        assertEquals(calculator.multiply(5, 3), 15);
    }

    @Test
    void divideTest() {

        assertEquals(calculator.divide(5, 2), 2.5, 0.0001);
    }
}