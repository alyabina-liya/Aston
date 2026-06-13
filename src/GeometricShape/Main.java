package GeometricShape;

public class Main {

    public static void main(String[] args) {

        Shape circle =
                new Circle(2, "Красный", "Черный");

        Shape rectangle =
                new Rectangle(10, 5,
                        "Синий",
                        "Черный");

        Shape triangle =
                new Triangle(3, 4, 5,
                        "Зеленый",
                        "Черный");

        System.out.println("Круг:");
        circle.printInfo();

        System.out.println("Прямоугольник:");
        rectangle.printInfo();

        System.out.println("Треугольник:");
        triangle.printInfo();
    }
}
