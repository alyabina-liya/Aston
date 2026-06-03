public class Main {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        boolean result1 = twoNumbers(5, 7);
        System.out.println(result1);
        System.out.println("_____");
        Numers(-5);
        boolean result2 = intNum(-40);
        System.out.println(result2);
        System.out.println("_____");
        printString("Summer", 3);
        System.out.println("_____");
        System.out.println("2026 год високосный? " + isLeapYear(2026));
        System.out.println("_____");
        changeArray();
        array();
        arrayTwo();
        diagonalArray();
        System.out.println("_____");
        int[] result = createArray(5, 7);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();


    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        System.out.println("_____");
    }

    public static void checkSumSign() {
        int a = 15;
        int b = 70;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
        System.out.println("_____");
    }

    public static void printColor() {
        int value = 101;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 100) {
            System.out.println("Зеленый");
        } else {
            System.out.println("Желтый");
        }
        System.out.println("_____");
    }

    public static void compareNumbers() {
        int a = 5;
        int b = 6;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
        System.out.println("_____");
    }

    public static boolean twoNumbers(int a, int b) {
        int sum = a + b;

        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void Numers(int num) {

        if (num >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательне число");
        }
        System.out.println("_____");
    }

    public static boolean intNum(int num) {

        if (num < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printString(String text, int count) {

        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static boolean isLeapYear(int year) {

        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void changeArray() {

        int[] arr = {1, 1, 0, 0, 1};
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println("_____");
    }

    public static void array() {

        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void arrayTwo() {

        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println("\n_____");
    }

    public static void diagonalArray() {

        int[][] arr = new int[5][5];

        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[] createArray(int len, int initialValue) {

        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }


}