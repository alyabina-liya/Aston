package test;

import main.CompareNumbers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompareNumbersTest {

    CompareNumbers compare = new CompareNumbers();

    @Test
    void greaterTest() {

        assertEquals(compare.compareNumbers(10, 5), ">");
    }

    @Test
    void lessTest() {
        assertEquals(compare.compareNumbers(5, 10), "<");
    }

    @Test
    void equalTest() {
        assertEquals(compare.compareNumbers(5, 5), "=");
    }
}