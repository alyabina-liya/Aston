public class Main {

    public static void main(String[] args) {

        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArray(array);
            System.out.println("Сумма элементов массива = " + result);

        } catch (MyArraySizeException exception) {
            System.out.println("Ошибка размера массива:");
            System.out.println(exception.getMessage());

        } catch (MyArrayDataException exception) {
            System.out.println("Ошибка данных массива:");
            System.out.println(exception.getMessage());
        }

        System.out.println("\nПроверка ArrayIndexOutOfBoundsException");

        try {
            int[] numbers = {1, 2, 3};

            System.out.println(numbers[5]);

        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(
                    "Попытка обращения к несуществующему элементу массива"
            );
        }
    }

    public static int sumArray(String[][] array)
            throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4) {
            throw new MyArraySizeException(
                    "Массив должен содержать 4 строки"
            );
        }

        for (int i = 0; i < array.length; i++) {

            if (array[i].length != 4) {

                throw new MyArraySizeException(
                        "Строка " + i +
                                " должна содержать 4 элемента"
                );
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {

                try {

                    sum += Integer.parseInt(array[i][j]);

                } catch (NumberFormatException e) {

                    throw new MyArrayDataException(
                            "Некорректные данные в ячейке ["
                                    + i + "][" + j + "] : "
                                    + array[i][j]
                    );
                }
            }
        }

        return sum;
    }
}