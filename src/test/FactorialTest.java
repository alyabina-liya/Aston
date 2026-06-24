package test;

import main.Factorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    Factorial factorial = new Factorial();

    @Test
    void factorialTest() {

        assertEquals(factorial.factorial(5), 120);
    }
}