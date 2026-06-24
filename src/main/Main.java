package main;

public class Main {

    public static void main(String[] args) {

        main.Calculator calculator = new main.Calculator();
        main.Factorial factorial = new main.Factorial();
        main.TriangleArea triangle = new main.TriangleArea();
        main.CompareNumbers compare = new main.CompareNumbers();

        System.out.println("Сумма: " + calculator.sum(5, 5));
        System.out.println("Вычитание: " + calculator.subtract(5, 5));
        System.out.println("Умножение: " + calculator.multiply(5, 5));
        System.out.println("Деление: " + calculator.divide(25, 5));
        System.out.println("Факториал: " + factorial.factorial(5));
        System.out.println("Площадь треугольника: " + triangle.triangleArea(10, 5));
        System.out.println("Сравнение: " + compare.compareNumbers(5, 10));
    }
}