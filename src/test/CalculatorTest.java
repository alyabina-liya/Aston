package test;

import main.Calculator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void sumTest() {
        assertEquals(calculator.sum(5, 3), 8);
    }

    @Test
    public void subtractTest() {
        assertEquals(calculator.subtract(5, 3), 2);
    }

    @Test
    public void multiplyTest() {
        assertEquals(calculator.multiply(5, 3), 15);
    }

    @Test
    public void divideTest() {
        assertEquals(calculator.divide(5, 2), 2.5);
    }
}