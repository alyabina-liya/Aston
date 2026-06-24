package main;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Factorial factorial = new Factorial();
        TriangleArea triangle = new TriangleArea();
        CompareNumbers compare = new CompareNumbers();

        System.out.println("Сумма: " + calculator.sum(5, 5));
        System.out.println("Разность: " + calculator.subtract(10, 5));
        System.out.println("Произведение: " + calculator.multiply(5, 5));
        System.out.println("Частное: " + calculator.divide(10, 5));

        System.out.println("Факториал: " + factorial.factorial(5));

        System.out.println("Площадь треугольника: "
                + triangle.triangleArea(10, 5));

        System.out.println("Сравнение: "
                + compare.compareNumbers(5, 10));
    }
}