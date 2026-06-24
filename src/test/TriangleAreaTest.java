package test;

import main.TriangleArea;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleAreaTest {

    TriangleArea triangleArea = new TriangleArea();

    @Test
    public void triangleAreaTest() {
        assertEquals(triangleArea.triangleArea(10, 5), 25.0);
    }
}
