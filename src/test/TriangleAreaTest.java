package test;

import main.TriangleArea;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleAreaTest {

    TriangleArea triangle = new TriangleArea();

    @Test
    void triangleAreaTest() {

        assertEquals(25.0, triangle.triangleArea(10, 5), 0.0001);
    }
}