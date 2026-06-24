package test;

import main.CompareNumbers;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CompareNumbersTest {

    CompareNumbers compare = new CompareNumbers();

    @Test
    public void compareNumbersGreaterTest() {
        assertEquals(compare.compareNumbers(10, 5), ">");
    }

    @Test
    public void compareNumbersLessTest() {
        assertEquals(compare.compareNumbers(5, 10), "<");
    }

    @Test
    public void compareNumbersEqualsTest() {
        assertEquals(compare.compareNumbers(5, 5), "=");
    }
}