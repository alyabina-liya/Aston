package test;

import main.Factorial;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTest {

    Factorial factorial = new Factorial();

    @Test
    public void factorialTest() {
        assertEquals(factorial.factorial(5), 120);
    }
}